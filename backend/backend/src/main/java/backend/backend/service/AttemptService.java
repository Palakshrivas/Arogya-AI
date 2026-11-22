package backend.backend.service;

import backend.backend.dto.AttemptRequest;
import backend.backend.dto.AttemptResponse;
import backend.backend.entity.Attempt;
import backend.backend.entity.Question;
import backend.backend.entity.User;
import backend.backend.repository.AttemptRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttemptService {

    private final AttemptRepository attemptRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public AttemptService(
            AttemptRepository attemptRepository,
            QuestionRepository questionRepository,
            UserRepository userRepository
    ) {
        this.attemptRepository = attemptRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public AttemptResponse submitAttempt(
            String email,
            AttemptRequest request
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean correct = question.getCorrectAnswer() != null
                && question.getCorrectAnswer().name().equalsIgnoreCase(request.getSelectedAnswer().trim());

        Attempt attempt = new Attempt();

        attempt.setUser(user);
        attempt.setQuestion(question);
        attempt.setSelectedAnswer(request.getSelectedAnswer());
        attempt.setCorrect(correct);
        attempt.setAttemptedAt(LocalDateTime.now());

        Attempt saved = attemptRepository.save(attempt);

        return new AttemptResponse(
                saved.getId(),
                question.getId(),
                saved.getSelectedAnswer(),
                question.getCorrectAnswer() != null ? question.getCorrectAnswer().name() : null,
                saved.isCorrect(),
                saved.getAttemptedAt()
        );
    }

    public List<AttemptResponse> getMyAttempts(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return attemptRepository
                .findByUserOrderByAttemptedAtDesc(user)
                .stream()
                .map(attempt -> new AttemptResponse(
                        attempt.getId(),
                        attempt.getQuestion().getId(),
                        attempt.getSelectedAnswer(),
                        attempt.getQuestion().getCorrectAnswer() != null ? attempt.getQuestion().getCorrectAnswer().name() : null,
                        attempt.isCorrect(),
                        attempt.getAttemptedAt()
                ))
                .toList();
    }
}