package backend.backend.repository;

import backend.backend.entity.Attempt;
import backend.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findByUserOrderByAttemptedAtDesc(User user);

    long countByUser(User user);

    long countByUserAndCorrect(User user, boolean correct);
}