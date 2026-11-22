package backend.backend.repository;

import backend.backend.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByExamIgnoreCase(String exam);

    Optional<Subject> findByNameIgnoreCaseAndExamIgnoreCase(
            String name,
            String exam
    );

    Optional<Subject> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}
