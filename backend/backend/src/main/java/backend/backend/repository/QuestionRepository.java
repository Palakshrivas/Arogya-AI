package backend.backend.repository;

import backend.backend.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExamIgnoreCase(String exam);

    List<Question> findBySubjectId(Long subjectId);

    List<Question> findByChapterId(Long chapterId);

    Page<Question> findByChapterId(Long chapterId, Pageable pageable);

    Page<Question> findByChapterIdAndDifficultyIgnoreCase(
            Long chapterId,
            String difficulty,
            Pageable pageable
    );

    List<Question> findByExamIgnoreCaseAndSubjectId(
            String exam,
            Long subjectId
    );

    List<Question> findByExamIgnoreCaseAndChapterId(
            String exam,
            Long chapterId
    );

    List<Question> findByDifficultyIgnoreCase(String difficulty);

    List<Question> findByTopicIgnoreCase(String topic);

    boolean existsByChapterId(Long chapterId);
}
