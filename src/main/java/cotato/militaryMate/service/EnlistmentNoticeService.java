package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.AcceptEnlistmentNoticeRespnse;
import cotato.militaryMate.domain.dto.enlistmentNotice.EnlistmentNoticeListResponse;
import cotato.militaryMate.domain.dto.enlistmentNotice.EnlistmentNoticeUsername;
import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeRequest;
import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeResponse;
import cotato.militaryMate.domain.entity.EnlistmentNotice;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.repository.EnlistmentNoticeRepository;
import cotato.militaryMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .sender(sender)
                .receiver(receiver)
                .build();
        return new SendEnlistmentNoticeResponse(enlistmentNoticeRepository.save(enlistmentNotice).getId());
    }

    public EnlistmentNoticeListResponse getReceivedEnlistmentNoticeList(Long receiverId) {
        User receiver = userRepository.findByUserId(receiverId);

        System.out.println(receiver.getNickname());
        List<EnlistmentNotice> enlistmentNoticeList = enlistmentNoticeRepository.findAllByReceiver(receiver);


        List<EnlistmentNoticeUsername> enlistmentNoticeUsernameList = new ArrayList<>();


        for (EnlistmentNotice en : enlistmentNoticeList) {
            System.out.println("_____________________________");
            System.out.println(en.getSender().getNickname());
            enlistmentNoticeUsernameList.add(new EnlistmentNoticeUsername(en.getSender().getUserId(), en.getSender().getNickname()));
        }
        return new EnlistmentNoticeListResponse(enlistmentNoticeUsernameList);
    }

    public AcceptEnlistmentNoticeRespnse create(Long senderId, Long receiverId) {
       User sender = userRepository.findById(senderId).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();

        EnlistmentNotice enlistmentNotice = EnlistmentNotice.builder()
                .sender(sender)
                .receiver(receiver)
                .build();
        return new AcceptEnlistmentNoticeRespnse(enlistmentNotice.getId());
    }
}
