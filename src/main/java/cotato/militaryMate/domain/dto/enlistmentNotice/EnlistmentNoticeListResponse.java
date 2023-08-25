package cotato.militaryMate.domain.dto.enlistmentNotice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EnlistmentNoticeListResponse {
    List<EnlistmentNoticeUsername> enlistmentNoticeList;
}
