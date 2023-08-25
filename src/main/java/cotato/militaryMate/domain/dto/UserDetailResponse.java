package cotato.militaryMate.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.domain.entity.UserDetail;
import cotato.militaryMate.enums.Answer;
import cotato.militaryMate.enums.SericeTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDetailResponse {

    private String email;
    private String nickname;
    private String city;
    private int age;
    private String smoke;
    private String mbti;
    private String hopeDay;
    private String hopeType;

    @Builder
    public UserDetailResponse(User user, UserDetail userDetail) {
        this.email = email;
        this.nickname = nickname;
        this.city = city;
        this.age = age;
        this.smoke = smoke;
        this.mbti = mbti;
        this.hopeDay = hopeDay;
        this.hopeType = hopeType;
    }
}
