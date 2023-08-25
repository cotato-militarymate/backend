package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.PostDto;
import cotato.militaryMate.domain.entity.Post;
import cotato.militaryMate.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    @Override
    public long createPost(PostDto.Request Request) {

        Post post = Post.builder()
                .title(Request.getTitle())
                .content(Request.getContent())
                .build();

       return postRepository.save(post).getId();
    }

    @Override
    public PostDto.getPost getPostDetail(long id) {
        Post post = postRepository.findById(id).get();

        PostDto.getPost postEntity = PostDto.getPost.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        return postEntity;
    }
}
