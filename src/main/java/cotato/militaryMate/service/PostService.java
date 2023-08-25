package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    long createPost(PostDto.Request Request);
    List<PostDto.GetPost> getPostDetail( );

    List<PostDto.GetPost> getAllPost();
}
