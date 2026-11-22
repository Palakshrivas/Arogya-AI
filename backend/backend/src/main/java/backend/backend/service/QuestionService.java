package backend.backend.service;

import backend.backend.dto.PageResponse;
import backend.backend.dto.QuestionRequest;
import backend.backend.dto.QuestionResponse;
import backend.backend.entity.Chapter;
import backend.backend.entity.Question;
import backend.backend.entity.Subject;
import backend.backend.enums.CorrectOption;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;
import backend.backend.exception.ResourceConflictException;
import backend.backend.exception.ResourceNotFoundException;
import backend.backend.mapper.QuestionMapper;
import backend.backend.repository.ChapterRepository;
import backend.backend.repository.QuestionRepository;
import backend.backend.repository.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final ChapterRepository chapterRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(
            QuestionRepository questionRepository,
            SubjectRepository subjectRepository,
            ChapterRepository chapterRepository,
            QuestionMapper questionMapper
    ) {
        this.questionRepository = questionRepository;
        this.subjectRepository = subjectRepository;
        this.chapterRepository = chapterRepository;
        this.questionMapper = questionMapper;
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

        CorrectOption correctOption = request.getCorrectOption() != null
                ? request.getCorrectOption()
                : request.getCorrectAnswer();

        ExamType examType = request.getExamType() != null
                ? request.getExamType()
                : request.getExam();

        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(correctOption);
        question.setExplanation(request.getExplanation());
        question.setExam(examType);
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());
        question.setSubject(subject);
        question.setChapter(chapter);

        Question saved = questionRepository.save(question);

        return questionMapper.toResponse(saved);
    }

    public List<QuestionResponse> getQuestions(
            ExamType exam,
            Long subjectId,
            Long chapterId,
            Difficulty difficulty,
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
                    .findByExamAndChapterId(
                            exam,
                            chapterId
                    );
        } else if (subjectId != null && exam != null) {
            questions = questionRepository
                    .findByExamAndSubjectId(
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
                    .findByExam(exam);
        } else if (difficulty != null) {
            questions = questionRepository
                    .findByDifficulty(difficulty);
        } else if (topic != null) {
            questions = questionRepository
                    .findByTopicIgnoreCase(topic);
        } else {
            questions = questionRepository.findAll();
        }

        return questions.stream()
                .map(questionMapper::toResponse)
                .toList();
    }

    public PageResponse<QuestionResponse> getQuestionsByChapter(
            Long chapterId,
            Difficulty difficulty,
            Pageable pageable
    ) {
        if (!chapterRepository.existsById(chapterId)) {
            throw new ResourceNotFoundException("Chapter not found with id: " + chapterId);
        }

        if (pageable.getPageSize() > 50) {
            pageable = PageRequest.of(pageable.getPageNumber(), 50, pageable.getSort());
        }

        Page<Question> questionPage;

        if (difficulty != null) {
            questionPage = questionRepository.findByChapterIdAndDifficulty(
                    chapterId,
                    difficulty,
                    pageable
            );
        } else {
            questionPage = questionRepository.findByChapterId(
                    chapterId,
                    pageable
            );
        }

        return PageResponse.of(questionPage, questionMapper::toResponse);
    }

    public QuestionResponse getQuestionById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id)
                );

        return questionMapper.toResponse(question);
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

        CorrectOption correctOption = request.getCorrectOption() != null
                ? request.getCorrectOption()
                : request.getCorrectAnswer();

        ExamType examType = request.getExamType() != null
                ? request.getExamType()
                : request.getExam();

        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(correctOption);
        question.setExplanation(request.getExplanation());
        question.setExam(examType);
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());
        question.setSubject(subject);
        question.setChapter(chapter);

        Question saved = questionRepository.save(question);
        return questionMapper.toResponse(saved);
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id)
                );

        questionRepository.delete(question);
    }
}
