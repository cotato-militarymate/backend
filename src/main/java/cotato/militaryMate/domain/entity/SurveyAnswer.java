package cotato.militaryMate.domain.entity;

import cotato.militaryMate.enums.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SurveyAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_answer_id")
    private int answerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_1;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_3;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_4;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_5;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_6;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_7;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_8;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_9;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer answer_10;


}
