package backend.backend.repository;

import backend.backend.entity.Question;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExam(ExamType exam);

    List<Question> findBySubjectId(Long subjectId);

    List<Question> findByChapterId(Long chapterId);

    Page<Question> findByChapterId(Long chapterId, Pageable pageable);

    Page<Question> findByChapterIdAndDifficulty(
            Long chapterId,
            Difficulty difficulty,
            Pageable pageable
    );

    List<Question> findByExamAndSubjectId(
            ExamType exam,
            Long subjectId
    );

    List<Question> findByExamAndChapterId(
            ExamType exam,
            Long chapterId
    );

    List<Question> findByDifficulty(Difficulty difficulty);

    List<Question> findByTopicIgnoreCase(String topic);

    boolean existsByChapterId(Long chapterId);
}
