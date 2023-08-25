package cotato.militaryMate.domain.dto.enlistmentNotice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnlistmentNoticeUsername {
    Long userId;
    String nickname;
}
