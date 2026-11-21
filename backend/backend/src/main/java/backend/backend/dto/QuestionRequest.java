package backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuestionRequest {

    @NotBlank
    private String questionText;

    @NotBlank
    private String optionA;

    @NotBlank
    private String optionB;

    @NotBlank
    private String optionC;

    @NotBlank
    private String optionD;

    @NotBlank
    private String correctAnswer;

    private String explanation;

    @NotBlank
    private String exam;

    @NotBlank
    private String difficulty;

    private String topic;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long chapterId;

    public QuestionRequest() {
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getExam() {
        return exam;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getChapterId() {
        return chapterId;
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

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}