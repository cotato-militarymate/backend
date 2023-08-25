package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.EmailDto;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final SpringTemplateEngine templateEngine;
    private final UserRepository userRepository;
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public EmailDto sendEmail(Long receiverId, Long senderId) throws MessagingException {
        MimeMessage emailForm = createEmailForm(receiverId, senderId);

        EmailDto res = EmailDto.builder().receiverId(receiverId).senderId(senderId).build();
        emailSender.send(emailForm);

        return res;
}

    @Override
    public MimeMessage createEmailForm(Long receiverId, Long senderId) throws MessagingException {

        User receiver = userRepository.findById(receiverId).get();
        User sender = userRepository.findById(senderId).get();

        String senderEmail = sender.getEmail();
        String receiverEmail = receiver.getEmail();
        String title = "군메이트 영장";

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        mimeMessage.addRecipients(MimeMessage.RecipientType.TO, receiverEmail);
        mimeMessage.setSubject(title);
        mimeMessage.setFrom(fromEmail);
        mimeMessage.setText(setContext(senderEmail), "utf-8", "html");

        return mimeMessage;
    }
    public String setContext(String senderEmail) {
        /*Thymeleaf기반의 html파일에 값을 넣고 연셜하는 메소드*/
        Context context = new Context();
        context.setVariable("email", senderEmail);
        return templateEngine.process("mail", context); //mail.html
    }

}
