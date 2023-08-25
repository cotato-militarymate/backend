package cotato.militaryMate.repository;

import cotato.militaryMate.domain.entity.User;
import cotato.militaryMate.domain.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    public Optional<UserDetail> findByUser(User user);
}
