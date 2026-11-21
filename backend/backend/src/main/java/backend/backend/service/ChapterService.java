package backend.backend.service;

import backend.backend.dto.ChapterResponse;
import backend.backend.entity.Chapter;
import backend.backend.entity.Subject;
import backend.backend.repository.ChapterRepository;
import backend.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final SubjectRepository subjectRepository;

    public ChapterService(
            ChapterRepository chapterRepository,
            SubjectRepository subjectRepository
    ) {
        this.chapterRepository = chapterRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<ChapterResponse> getChaptersBySubject(
            Long subjectId
    ) {

        return chapterRepository
                .findBySubjectIdOrderByNameAsc(subjectId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ChapterResponse createChapter(
            String name,
            Long subjectId
    ) {

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new RuntimeException("Subject not found")
                );

        Chapter chapter = new Chapter(name, subject);

        Chapter saved = chapterRepository.save(chapter);

        return toResponse(saved);
    }

    private ChapterResponse toResponse(Chapter chapter) {

        return new ChapterResponse(
                chapter.getId(),
                chapter.getName(),
                chapter.getSubject().getId(),
                chapter.getSubject().getName()
        );
    }
}