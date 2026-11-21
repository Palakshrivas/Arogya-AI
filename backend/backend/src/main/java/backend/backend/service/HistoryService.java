package backend.backend.service;

import backend.backend.dto.HistoryRequest;
import backend.backend.dto.HistoryResponse;
import backend.backend.entity.History;
import backend.backend.entity.Question;
import backend.backend.entity.User;
import backend.backend.repository.HistoryRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public HistoryService(
            HistoryRepository historyRepository,
            UserRepository userRepository,
            QuestionRepository questionRepository
    ) {
        this.historyRepository = historyRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public HistoryResponse createHistory(
            String email,
            HistoryRequest request
    ) {

        User user = getUser(email);

        History history = new History();

        history.setUser(user);

        if (request.getQuestionId() != null) {
            Question question = questionRepository
                    .findById(request.getQuestionId())
                    .orElseThrow(() ->
                            new RuntimeException("Question not found")
                    );

            history.setQuestion(question);
        }

        history.setExam(request.getExam().toUpperCase());
        history.setSubject(request.getSubject());
        history.setChapter(request.getChapter());
        history.setSelectedAnswer(request.getSelectedAnswer());
        history.setCorrectAnswer(request.getCorrectAnswer());
        history.setCorrect(request.getCorrect());
        history.setTimeTaken(request.getTimeTaken());

        return toResponse(
                historyRepository.save(history)
        );
    }

    public List<HistoryResponse> getHistory(
            String email,
            String exam
    ) {

        User user = getUser(email);

        List<History> history;

        if (exam == null || exam.isBlank()) {
            history = historyRepository
                    .findByUserIdOrderByAttemptedAtDesc(user.getId());
        } else {
            history = historyRepository
                    .findByUserIdAndExamIgnoreCaseOrderByAttemptedAtDesc(
                            user.getId(),
                            exam
                    );
        }

        return history.stream()
                .map(this::toResponse)
                .toList();
    }

    private User getUser(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );
    }

    private HistoryResponse toResponse(History history) {

        return new HistoryResponse(
                history.getId(),
                history.getQuestion() != null
                        ? history.getQuestion().getId()
                        : null,
                history.getExam(),
                history.getSubject(),
                history.getChapter(),
                history.getSelectedAnswer(),
                history.getCorrectAnswer(),
                history.getCorrect(),
                history.getTimeTaken(),
                history.getAttemptedAt()
        );
    }
}
