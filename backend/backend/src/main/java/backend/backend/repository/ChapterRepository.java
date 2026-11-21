package backend.backend.repository;

import backend.backend.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    List<Chapter> findBySubjectIdOrderByNameAsc(Long subjectId);

    Optional<Chapter> findByNameIgnoreCaseAndSubjectId(
            String name,
            Long subjectId
    );
}
