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

    private final PostService postServiceImpl;
    @PostMapping("/create")
    public ApiResponse<?> createPost(@RequestBody PostDto.Request req){

        return ApiResponse.createSuccess(postServiceImpl.createPost(req));
    }

    @GetMapping("/list")
    public ApiResponse<?> getPost(){
        return ApiResponse.createSuccess(postServiceImpl.getPostDetail());
    }

    @GetMapping("/list/all")
    public ApiResponse<?> getAllPost(){
        return ApiResponse.createSuccess(postServiceImpl.getAllPost());
    }
}
