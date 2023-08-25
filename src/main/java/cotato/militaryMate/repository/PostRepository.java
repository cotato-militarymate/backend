package cotato.militaryMate.repository;

import cotato.militaryMate.domain.dto.PostDto;
import cotato.militaryMate.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

//    List<PostDto.GetPost> findByTop3ByOrderByIdDesc();
    List<Post> findAllBy();
}
