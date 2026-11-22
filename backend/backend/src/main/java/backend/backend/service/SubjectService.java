package backend.backend.service;

import backend.backend.dto.SubjectRequest;
import backend.backend.dto.SubjectResponse;
import backend.backend.entity.Subject;
import backend.backend.exception.DuplicateResourceException;
import backend.backend.exception.ResourceConflictException;
import backend.backend.exception.ResourceNotFoundException;
import backend.backend.mapper.SubjectMapper;
import backend.backend.repository.ChapterRepository;
import backend.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ChapterRepository chapterRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(
            SubjectRepository subjectRepository,
            ChapterRepository chapterRepository,
            SubjectMapper subjectMapper
    ) {
        this.subjectRepository = subjectRepository;
        this.chapterRepository = chapterRepository;
        this.subjectMapper = subjectMapper;
    }

    public List<SubjectResponse> getAllSubjects(String exam) {

        List<Subject> subjects;

        if (exam == null || exam.isBlank()) {
            subjects = subjectRepository.findAll();
        } else {
            subjects = subjectRepository.findByExamIgnoreCase(exam);
        }

        return subjects.stream()
                .map(subjectMapper::toResponse)
                .toList();
    }

    public SubjectResponse getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id)
                );
        return subjectMapper.toResponse(subject);
    }

    public SubjectResponse createSubject(SubjectRequest request) {
        if (subjectRepository.existsByNameIgnoreCase(request.getName())) {
            throw new DuplicateResourceException(
                    "Subject already exists with name: " + request.getName()
            );
        }

        String exam = request.getExamType() != null
                ? request.getExamType().toUpperCase()
                : "";

        Subject subject = new Subject(request.getName(), exam);
        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toResponse(saved);
    }

    public SubjectResponse createSubject(
            String name,
            String exam
    ) {
        if (subjectRepository.existsByNameIgnoreCase(name)) {
            throw new DuplicateResourceException(
                    "Subject already exists with name: " + name
            );
        }

        Subject subject = new Subject(name, exam != null ? exam.toUpperCase() : "");
        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toResponse(saved);
    }

    public SubjectResponse updateSubject(Long id, SubjectRequest request) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id)
                );

        subjectRepository.findByNameIgnoreCase(request.getName()).ifPresent(existing -> {
            if (!existing.getId().equals(id)) {
                throw new DuplicateResourceException(
                        "Subject already exists with name: " + request.getName()
                );
            }
        });

        subject.setName(request.getName());
        if (request.getExamType() != null) {
            subject.setExam(request.getExamType().toUpperCase());
        }

        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toResponse(saved);
    }

    public void deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found with id: " + id)
                );

        if (chapterRepository.existsBySubjectId(id)) {
            throw new ResourceConflictException(
                    "Cannot delete subject with id " + id + " because it still has associated chapters"
            );
        }

        subjectRepository.delete(subject);
    }
}
