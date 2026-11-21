package backend.backend.repository;

import backend.backend.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUserIdOrderByAttemptedAtDesc(Long userId);

    List<History> findByUserIdAndExamIgnoreCaseOrderByAttemptedAtDesc(
            Long userId,
            String exam
    );

    List<History> findByUserIdAndCorrectOrderByAttemptedAtDesc(
            Long userId,
            Boolean correct
    );
}