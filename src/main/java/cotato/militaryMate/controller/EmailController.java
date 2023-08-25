package cotato.militaryMate.controller;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.EmailDto;
import cotato.militaryMate.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enlistment_notice/mail/")
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/{senderId}/{receiverID}")
    public ApiResponse<EmailDto> sendEmail(@PathVariable Long receiverID, @PathVariable Long senderId) throws MessagingException {

        return ApiResponse.createSuccess(emailService.sendEmail(receiverID, senderId));
    }
}
