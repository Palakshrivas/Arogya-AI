package backend.backend.service;

import backend.backend.dto.MistakeRequest;
import backend.backend.dto.MistakeResponse;
import backend.backend.entity.Mistake;
import backend.backend.entity.Question;
import backend.backend.entity.User;
import backend.backend.repository.MistakeRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MistakeService {

    private final MistakeRepository mistakeRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public MistakeService(
            MistakeRepository mistakeRepository,
            UserRepository userRepository,
            QuestionRepository questionRepository
    ) {
        this.mistakeRepository = mistakeRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public MistakeResponse createMistake(
            String email,
            MistakeRequest request
    ) {

        User user = getUser(email);

        if (request.getQuestionId() != null
                && mistakeRepository.existsByUserIdAndQuestionId(
                        user.getId(),
                        request.getQuestionId()
                )) {

            throw new RuntimeException(
                    "This question is already in mistakes"
            );
        }

        Mistake mistake = new Mistake();

        mistake.setUser(user);

        if (request.getQuestionId() != null) {

            Question question = questionRepository
                    .findById(request.getQuestionId())
                    .orElseThrow(() ->
                            new RuntimeException("Question not found")
                    );

            mistake.setQuestion(question);
        }

        mistake.setQuestionText(request.getQuestionText());
        mistake.setExam(request.getExam().toUpperCase());
        mistake.setSubject(request.getSubject());
        mistake.setChapter(request.getChapter());
        mistake.setSelectedAnswer(request.getSelectedAnswer());
        mistake.setCorrectAnswer(request.getCorrectAnswer());
        mistake.setExplanation(request.getExplanation());

        return toResponse(
                mistakeRepository.save(mistake)
        );
    }

    public List<MistakeResponse> getMistakes(
            String email,
            String exam
    ) {

        User user = getUser(email);

        List<Mistake> mistakes;

        if (exam == null || exam.isBlank()) {

            mistakes = mistakeRepository
                    .findByUserIdOrderByCreatedAtDesc(user.getId());

        } else {

            mistakes = mistakeRepository
                    .findByUserIdAndExamIgnoreCaseOrderByCreatedAtDesc(
                            user.getId(),
                            exam
                    );
        }

        return mistakes.stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteMistake(
            String email,
            Long id
    ) {

        User user = getUser(email);

        Mistake mistake = mistakeRepository
                .findByIdAndUserId(id, user.getId())
                .orElseThrow(() ->
                        new RuntimeException("Mistake not found")
                );

        mistakeRepository.delete(mistake);
    }

    private User getUser(String email) {

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );
    }

    private MistakeResponse toResponse(Mistake mistake) {

        return new MistakeResponse(
                mistake.getId(),
                mistake.getQuestion() != null
                        ? mistake.getQuestion().getId()
                        : null,
                mistake.getQuestionText(),
                mistake.getExam(),
                mistake.getSubject(),
                mistake.getChapter(),
                mistake.getSelectedAnswer(),
                mistake.getCorrectAnswer(),
                mistake.getExplanation(),
                mistake.getCreatedAt()
        );
    }
}
