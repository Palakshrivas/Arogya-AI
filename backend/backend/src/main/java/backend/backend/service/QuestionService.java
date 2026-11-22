package backend.backend.service;

import backend.backend.dto.QuestionRequest;
import backend.backend.dto.QuestionResponse;
import backend.backend.entity.Chapter;
import backend.backend.entity.Question;
import backend.backend.entity.Subject;
import backend.backend.exception.ResourceConflictException;
import backend.backend.exception.ResourceNotFoundException;
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
        Chapter chapter = chapterRepository
                .findById(request.getChapterId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Chapter not found with id: " + request.getChapterId())
                );

        Subject subject;
        if (request.getSubjectId() != null) {
            subject = subjectRepository
                    .findById(request.getSubjectId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Subject not found with id: " + request.getSubjectId())
                    );

            if (!chapter.getSubject().getId().equals(subject.getId())) {
                throw new ResourceConflictException(
                        "Chapter does not belong to selected subject"
                );
            }
        } else {
            subject = chapter.getSubject();
        }

        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(request.getCorrectOption() != null ? request.getCorrectOption() : request.getCorrectAnswer());
        question.setExplanation(request.getExplanation());
        String exam = request.getExamType() != null ? request.getExamType() : request.getExam();
        question.setExam(exam != null ? exam.toUpperCase() : "");
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
        if (subjectId != null && !subjectRepository.existsById(subjectId)) {
            throw new ResourceNotFoundException("Subject not found with id: " + subjectId);
        }

        if (chapterId != null && !chapterRepository.existsById(chapterId)) {
            throw new ResourceNotFoundException("Chapter not found with id: " + chapterId);
        }

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
                        new ResourceNotFoundException("Question not found with id: " + id)
                );

        return toResponse(question);
    }

    public QuestionResponse updateQuestion(Long id, QuestionRequest request) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id)
                );

        Chapter chapter = chapterRepository
                .findById(request.getChapterId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Chapter not found with id: " + request.getChapterId())
                );

        Subject subject;
        if (request.getSubjectId() != null) {
            subject = subjectRepository
                    .findById(request.getSubjectId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Subject not found with id: " + request.getSubjectId())
                    );

            if (!chapter.getSubject().getId().equals(subject.getId())) {
                throw new ResourceConflictException(
                        "Chapter does not belong to selected subject"
                );
            }
        } else {
            subject = chapter.getSubject();
        }

        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(request.getCorrectOption() != null ? request.getCorrectOption() : request.getCorrectAnswer());
        question.setExplanation(request.getExplanation());
        String exam = request.getExamType() != null ? request.getExamType() : request.getExam();
        question.setExam(exam != null ? exam.toUpperCase() : "");
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());
        question.setSubject(subject);
        question.setChapter(chapter);

        Question saved = questionRepository.save(question);
        return toResponse(saved);
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id)
                );

        questionRepository.delete(question);
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
