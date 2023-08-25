package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.PostDto;

public interface PostService {

    long createPost(PostDto.Request Request);
    PostDto.getPost getPostDetail(long id);

}
