package cotato.militaryMate.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String email;
    private String nickname;
    private String city;
    private int age;
}
