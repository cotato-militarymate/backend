package cotato.militaryMate.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column
    private int age;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String city;

    @Column
    private int age;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private SurveyAnswer surveyAnswer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetail userDetail;
}
