package backend.backend.repository;

import backend.backend.entity.Mistake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MistakeRepository extends JpaRepository<Mistake, Long> {

    List<Mistake> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Mistake> findByUserIdAndExamIgnoreCaseOrderByCreatedAtDesc(
            Long userId,
            String exam
    );

    Optional<Mistake> findByIdAndUserId(
            Long id,
            Long userId
    );

    boolean existsByUserIdAndQuestionId(
            Long userId,
            Long questionId
    );
}