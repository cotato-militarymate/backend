package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeRequest;
import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeResponse;
import cotato.militaryMate.domain.entity.EnlistmentNotice;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.repository.EnlistmentNoticeRepository;
import cotato.militaryMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnlistmentNoticeService {
    private final EnlistmentNoticeRepository enlistmentNoticeRepository;
    private final UserRepository userRepository;

    public SendEnlistmentNoticeResponse sendEnlistmentNotice(SendEnlistmentNoticeRequest request) {
        User sender = userRepository.findByUserId(request.getSenderId());
        User receiver = userRepository.findByUserId(request.getReceiverId());
        EnlistmentNotice enlistmentNotice = EnlistmentNotice.builder()
                .sender_id(sender)
                .receiver_id(receiver)
                .build();
        return new SendEnlistmentNoticeResponse(enlistmentNoticeRepository.save(enlistmentNotice).getId());
    }

    public EnlistmentNoticeListResponse getReceivedEnlistmentNoticeList(Long receiverId) {
        User receiver = userRepository.findByUserId(receiverId);
        List<EnlistmentNotice> enlistmentNoticeList = enlistmentNoticeRepository.findAllByReceiver_id(receiver);

    }
}
