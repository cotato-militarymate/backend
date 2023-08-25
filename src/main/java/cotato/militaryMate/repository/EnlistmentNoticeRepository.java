package cotato.militaryMate.repository;

import cotato.militaryMate.domain.entity.EnlistmentNotice;
import cotato.militaryMate.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnlistmentNoticeRepository extends JpaRepository<EnlistmentNotice, Long> {
    List<EnlistmentNotice> findAllByReceiver_id(User user);
}