package cotato.militaryMate.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import cotato.militaryMate.enums.Answer;
import cotato.militaryMate.enums.ExcerciseAbilityEnum;
import cotato.militaryMate.enums.SericeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String kakaoTalkAccount;
    @Enumerated(value = EnumType.STRING)
    private Answer smoke;
    private String mbti;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime hopeDay;
    private SericeTypeEnum hopeType;
    private ExcerciseAbilityEnum exerciseAbility;
}
