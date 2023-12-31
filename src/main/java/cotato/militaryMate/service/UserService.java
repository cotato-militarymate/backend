package cotato.militaryMate.service;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.UserDetailResponse;
import cotato.militaryMate.domain.dto.UserResponse;
import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.domain.entity.UserDetail;
import cotato.militaryMate.repository.UserDetailRepository;
import cotato.militaryMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    @Transactional
    public UserResponse findUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return  UserResponse.builder()
                .email(user.getEmail())
                .city(user.getCity())
                .nickname(user.getNickname())
                .age(user.getAge())
                .build();

    }

    @Transactional
    public UserDetailResponse findUserDetail(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        UserDetail userDetail = userDetailRepository.findByUser(user).orElseThrow();
        return  UserDetailResponse.builder()
                .user(user)
                .userDetail(userDetail)
                .build();

    }
}
