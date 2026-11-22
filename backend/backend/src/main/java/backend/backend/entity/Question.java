package backend.backend.entity;

import backend.backend.enums.CorrectOption;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;
import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;

    @Column(nullable = false)
    private String optionA;

    @Column(nullable = false)
    private String optionB;

    @Column(nullable = false)
    private String optionC;

    @Column(nullable = false)
    private String optionD;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CorrectOption correctAnswer;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamType exam;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public CorrectOption getCorrectAnswer() {
        return correctAnswer;
    }

    public CorrectOption getCorrectOption() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public ExamType getExam() {
        return exam;
    }

    public ExamType getExamType() {
        return exam;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public Subject getSubject() {
        return subject;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setCorrectAnswer(CorrectOption correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setCorrectOption(CorrectOption correctOption) {
        this.correctAnswer = correctOption;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setExam(ExamType exam) {
        this.exam = exam;
    }

    public void setExamType(ExamType examType) {
        this.exam = examType;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
