package backend.backend.repository;

import backend.backend.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByUserIdOrderByLastUpdatedDesc(Long userId);

    Optional<Progress> findByUserIdAndSubjectIgnoreCaseAndExamIgnoreCase(
            Long userId,
            String subject,
            String exam
    );
}