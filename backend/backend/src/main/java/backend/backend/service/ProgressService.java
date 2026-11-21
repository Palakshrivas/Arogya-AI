package backend.backend.service;

import backend.backend.dto.ProgressRequest;
import backend.backend.dto.ProgressResponse;
import backend.backend.entity.Progress;
import backend.backend.entity.User;
import backend.backend.repository.ProgressRepository;
import backend.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;

    public ProgressService(
            ProgressRepository progressRepository,
            UserRepository userRepository
    ) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
    }

    public ProgressResponse saveOrUpdate(
            String email,
            ProgressRequest request
    ) {

        User user = getUser(email);

        Progress progress = progressRepository
                .findByUserIdAndSubjectIgnoreCaseAndExamIgnoreCase(
                        user.getId(),
                        request.getSubject(),
                        request.getExam()
                )
                .orElseGet(Progress::new);

        progress.setUser(user);
        progress.setSubject(request.getSubject());
        progress.setExam(request.getExam().toUpperCase());
        progress.setQuestionsAttempted(
                request.getQuestionsAttempted()
        );
        progress.setCorrectAnswers(
                request.getCorrectAnswers()
        );
        progress.setIncorrectAnswers(
                request.getIncorrectAnswers()
        );
        progress.setStudyTimeMinutes(
                request.getStudyTimeMinutes()
        );

        return toResponse(
                progressRepository.save(progress)
        );
    }

    public List<ProgressResponse> getAll(
            String email
    ) {

        User user = getUser(email);

        return progressRepository
                .findByUserIdOrderByLastUpdatedDesc(user.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProgressResponse getBySubject(
            String email,
            String subject,
            String exam
    ) {

        User user = getUser(email);

        Progress progress = progressRepository
                .findByUserIdAndSubjectIgnoreCaseAndExamIgnoreCase(
                        user.getId(),
                        subject,
                        exam
                )
                .orElseThrow(() ->
                        new RuntimeException("Progress not found")
                );

        return toResponse(progress);
    }

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );
    }

    private ProgressResponse toResponse(
            Progress progress
    ) {

        return new ProgressResponse(
                progress.getId(),
                progress.getSubject(),
                progress.getExam(),
                progress.getQuestionsAttempted(),
                progress.getCorrectAnswers(),
                progress.getIncorrectAnswers(),
                progress.getAccuracy(),
                progress.getStudyTimeMinutes(),
                progress.getLastUpdated()
        );
    }
}