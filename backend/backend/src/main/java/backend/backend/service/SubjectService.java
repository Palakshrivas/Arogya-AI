package backend.backend.service;

import backend.backend.dto.SubjectResponse;
import backend.backend.entity.Subject;
import backend.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectResponse> getAllSubjects(String exam) {

        List<Subject> subjects;

        if (exam == null || exam.isBlank()) {
            subjects = subjectRepository.findAll();
        } else {
            subjects = subjectRepository.findByExamIgnoreCase(exam);
        }

        return subjects.stream()
                .map(subject -> new SubjectResponse(
                        subject.getId(),
                        subject.getName(),
                        subject.getExam()
                ))
                .toList();
    }

    public SubjectResponse createSubject(
            String name,
            String exam
    ) {

        Subject subject = new Subject(name, exam.toUpperCase());

        Subject saved = subjectRepository.save(subject);

        return new SubjectResponse(
                saved.getId(),
                saved.getName(),
                saved.getExam()
        );
    }
}