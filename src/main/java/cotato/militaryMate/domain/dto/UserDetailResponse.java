package cotato.militaryMate.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.domain.entity.UserDetail;
import cotato.militaryMate.enums.Answer;
import cotato.militaryMate.enums.SericeTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDetailResponse {

    private String email;
    private String nickname;
    private String city;
    private int age;
    private int smoke;
    private String mbti;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime hopeDay;
    private String hopeType;

    @Builder
    public UserDetailResponse(User user, UserDetail userDetail) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.city = user.getCity();
        this.age = user.getAge();
        this.smoke = userDetail.getSmoke().getStatus();
        this.mbti = userDetail.getMbti();
        this.hopeDay = userDetail.getHopeDay();
        this.hopeType = userDetail.getHopeType().getType();
    }
}
