package backend.backend.service;

import backend.backend.dto.QuestionRequest;
import backend.backend.dto.QuestionResponse;
import backend.backend.entity.Chapter;
import backend.backend.entity.Question;
import backend.backend.entity.Subject;
import backend.backend.repository.ChapterRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final ChapterRepository chapterRepository;

    public QuestionService(
            QuestionRepository questionRepository,
            SubjectRepository subjectRepository,
            ChapterRepository chapterRepository
    ) {
        this.questionRepository = questionRepository;
        this.subjectRepository = subjectRepository;
        this.chapterRepository = chapterRepository;
    }

    public QuestionResponse createQuestion(
            QuestionRequest request
    ) {

        Subject subject = subjectRepository
                .findById(request.getSubjectId())
                .orElseThrow(() ->
                        new RuntimeException("Subject not found")
                );

        Chapter chapter = chapterRepository
                .findById(request.getChapterId())
                .orElseThrow(() ->
                        new RuntimeException("Chapter not found")
                );

        if (!chapter.getSubject().getId().equals(subject.getId())) {
            throw new RuntimeException(
                    "Chapter does not belong to selected subject"
            );
        }

        Question question = new Question();

        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(request.getCorrectAnswer());
        question.setExplanation(request.getExplanation());
        question.setExam(request.getExam().toUpperCase());
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());
        question.setSubject(subject);
        question.setChapter(chapter);

        Question saved = questionRepository.save(question);

        return toResponse(saved);
    }

    public List<QuestionResponse> getQuestions(
            String exam,
            Long subjectId,
            Long chapterId,
            String difficulty,
            String topic
    ) {

        List<Question> questions;

        if (chapterId != null && exam != null) {

            questions = questionRepository
                    .findByExamIgnoreCaseAndChapterId(
                            exam,
                            chapterId
                    );

        } else if (subjectId != null && exam != null) {

            questions = questionRepository
                    .findByExamIgnoreCaseAndSubjectId(
                            exam,
                            subjectId
                    );

        } else if (chapterId != null) {

            questions = questionRepository
                    .findByChapterId(chapterId);

        } else if (subjectId != null) {

            questions = questionRepository
                    .findBySubjectId(subjectId);

        } else if (exam != null) {

            questions = questionRepository
                    .findByExamIgnoreCase(exam);

        } else if (difficulty != null) {

            questions = questionRepository
                    .findByDifficultyIgnoreCase(difficulty);

        } else if (topic != null) {

            questions = questionRepository
                    .findByTopicIgnoreCase(topic);

        } else {

            questions = questionRepository.findAll();
        }

        return questions.stream()
                .map(this::toResponse)
                .toList();
    }

    public QuestionResponse getQuestionById(Long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question not found")
                );

        return toResponse(question);
    }

    private QuestionResponse toResponse(
            Question question
    ) {

        return new QuestionResponse(
                question.getId(),
                question.getQuestionText(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD(),
                question.getCorrectAnswer(),
                question.getExplanation(),
                question.getExam(),
                question.getDifficulty(),
                question.getTopic(),
                question.getSubject() != null
                        ? question.getSubject().getId()
                        : null,
                question.getSubject() != null
                        ? question.getSubject().getName()
                        : null,
                question.getChapter() != null
                        ? question.getChapter().getId()
                        : null,
                question.getChapter() != null
                        ? question.getChapter().getName()
                        : null
        );
    }
}