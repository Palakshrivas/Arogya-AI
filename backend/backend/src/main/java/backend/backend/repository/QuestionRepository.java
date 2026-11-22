package backend.backend.repository;

import backend.backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExamIgnoreCase(String exam);

    List<Question> findBySubjectId(Long subjectId);

    List<Question> findByChapterId(Long chapterId);

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
