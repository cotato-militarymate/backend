package cotato.militaryMate.controller;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.UserDetailResponse;
import cotato.militaryMate.domain.dto.UserResponse;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.repository.UserRepository;
import cotato.militaryMate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> getUserAttribute(@PathVariable Long userId) {
        return ApiResponse.createSuccess(userService.findUser(userId));
    }

    @GetMapping("/detail/{userId}")
    public ApiResponse<UserDetailResponse> getUserDetailAttribute(@PathVariable Long userId) {
        return ApiResponse.createSuccess(userService.findUserDetail(userId));
    }

}
