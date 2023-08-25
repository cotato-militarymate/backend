package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.EmailDto;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailService {
    //TODO: return form DTO로 변환
    EmailDto sendEmail(Long receiverId, Long senderId) throws MessagingException;
    MimeMessage createEmailForm(Long receiverId, Long senderId) throws MessagingException;
}
