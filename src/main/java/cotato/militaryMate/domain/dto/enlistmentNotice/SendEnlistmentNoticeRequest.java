package cotato.militaryMate.domain.dto.enlistmentNotice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEnlistmentNoticeRequest {
    Long senderId;
    Long receiverId;
}
