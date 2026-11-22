package backend.backend.repository;

import backend.backend.entity.Subject;
import backend.backend.enums.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByExam(ExamType exam);

    Optional<Subject> findByNameIgnoreCaseAndExam(
            String name,
            ExamType exam
    );

    Optional<Subject> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}
