package backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HistoryRequest {

    private Long questionId;

    @NotBlank
    private String exam;

    @NotBlank
    private String subject;

    private String chapter;

    private String selectedAnswer;

    private String correctAnswer;

    @NotNull
    private Boolean correct;

    private Integer timeTaken;

    public HistoryRequest() {
    }

    public Long getQuestionId() {
        return questionId;
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

    public Boolean getCorrect() {
        return correct;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }
}