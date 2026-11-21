package backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MistakeRequest {

    private Long questionId;

    @NotBlank
    private String questionText;

    @NotBlank
    private String exam;

    private String subject;

    private String chapter;

    private String selectedAnswer;

    private String correctAnswer;

    private String explanation;

    public MistakeRequest() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getExam() {
        return exam;
    }

    public String getSubject() {
        return subject;
    }

    public String getChapter() {
        return chapter;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
