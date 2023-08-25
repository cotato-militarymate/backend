package cotato.militaryMate.controller;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.PostDto;
import cotato.militaryMate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    @PostMapping("/create")
    public ApiResponse<?> createPost(@RequestBody PostDto.Request req){

        return ApiResponse.createSuccess(postService.createPost(req));
    }

    @GetMapping("/{postId}")
    public ApiResponse<?> getPost(@PathVariable Long postId){
        return ApiResponse.createSuccess(postService.getPostDetail(postId));
    }
}
