package cotato.militaryMate.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

    @Builder
    public Post(User user, String content, String title) {
        this.user = user;
        this.title = title;
        this.content = content;
    }
}
