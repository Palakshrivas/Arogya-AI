package backend.backend.service;

import backend.backend.dto.ChapterRequest;
import backend.backend.dto.ChapterResponse;
import backend.backend.entity.Chapter;
import backend.backend.entity.Subject;
import backend.backend.exception.ResourceConflictException;
import backend.backend.exception.ResourceNotFoundException;
import backend.backend.mapper.ChapterMapper;
import backend.backend.repository.ChapterRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;
    private final ChapterMapper chapterMapper;

    public ChapterService(
            ChapterRepository chapterRepository,
            SubjectRepository subjectRepository,
            QuestionRepository questionRepository,
            ChapterMapper chapterMapper
    ) {
        this.chapterRepository = chapterRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.chapterMapper = chapterMapper;
    }

    public List<ChapterResponse> getChaptersBySubject(
            Long subjectId
    ) {
        if (!subjectRepository.existsById(subjectId)) {
            throw new ResourceNotFoundException("Subject not found with id: " + subjectId);
        }

        return chapterRepository
                .findBySubjectIdOrderByNameAsc(subjectId)
                .stream()
                .map(chapterMapper::toResponse)
                .toList();
    }

    public ChapterResponse getChapterById(Long id) {
        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Chapter not found with id: " + id)
                );
        return chapterMapper.toResponse(chapter);
    }

    public ChapterResponse createChapter(ChapterRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + request.getSubjectId())
                );

        Chapter chapter = new Chapter(request.getName(), subject);
        Chapter saved = chapterRepository.save(chapter);
        return chapterMapper.toResponse(saved);
    }

    public ChapterResponse createChapter(
            String name,
            Long subjectId
    ) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + subjectId)
                );

        Chapter chapter = new Chapter(name, subject);
        Chapter saved = chapterRepository.save(chapter);
        return chapterMapper.toResponse(saved);
    }

    public ChapterResponse updateChapter(Long id, ChapterRequest request) {
        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Chapter not found with id: " + id)
                );

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + request.getSubjectId())
                );

        chapter.setName(request.getName());
        chapter.setSubject(subject);
        Chapter saved = chapterRepository.save(chapter);
        return chapterMapper.toResponse(saved);
    }

    public void deleteChapter(Long id) {
        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Chapter not found with id: " + id)
                );

        if (questionRepository.existsByChapterId(id)) {
            throw new ResourceConflictException(
                    "Cannot delete chapter with id " + id + " because it still has associated questions"
            );
        }

        chapterRepository.delete(chapter);
    }
}
