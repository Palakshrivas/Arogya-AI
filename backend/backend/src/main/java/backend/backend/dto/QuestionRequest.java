package backend.backend.dto;

import backend.backend.enums.CorrectOption;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class QuestionRequest {

    @NotBlank(message = "Question text must not be blank")
    private String questionText;

    @NotBlank(message = "Option A must not be blank")
    private String optionA;

    @NotBlank(message = "Option B must not be blank")
    private String optionB;

    @NotBlank(message = "Option C must not be blank")
    private String optionC;

    @NotBlank(message = "Option D must not be blank")
    private String optionD;

    @NotNull(message = "Correct option must not be null")
    @JsonAlias({"correctOption", "correctAnswer"})
    private CorrectOption correctOption;

    private String explanation;

    @NotNull(message = "Exam type must not be null")
    @JsonAlias({"exam", "examType"})
    private ExamType examType;

    @NotNull(message = "Difficulty must not be null")
    @JsonAlias({"difficulty", "difficultyLevel"})
    private Difficulty difficulty;

    private String topic;

    private Long subjectId;

    @NotNull(message = "Chapter ID must not be null")
    @Positive(message = "Chapter ID must be positive")
    private Long chapterId;

    public QuestionRequest() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public CorrectOption getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(CorrectOption correctOption) {
        this.correctOption = correctOption;
    }

    public CorrectOption getCorrectAnswer() {
        return correctOption;
    }

    public void setCorrectAnswer(CorrectOption correctAnswer) {
        this.correctOption = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public ExamType getExam() {
        return examType;
    }

    public void setExam(ExamType exam) {
        this.examType = exam;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}
