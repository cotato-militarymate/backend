package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.PostDto;
import cotato.militaryMate.domain.entity.Post;
import cotato.militaryMate.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
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
    public List<PostDto.GetPost> getPostDetail( ) {
        List<Post> all = postRepository.findAll();
        List<PostDto.GetPost> lists=new ArrayList<>();

        int i=0;
        for(Post post : all){
            PostDto.GetPost build = PostDto.GetPost.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build();

            lists.add(build);
            i++;
            if(i>=3) break;
        }

        return lists;
    }

    @Override
    public List<PostDto.GetPost> getAllPost() {
        List<Post> all = postRepository.findAll();

        List<PostDto.GetPost> lists=new ArrayList<>();
        for(Post post : all){
            PostDto.GetPost build = PostDto.GetPost.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build();

            lists.add(build);
        }

        return lists;
    }
}
