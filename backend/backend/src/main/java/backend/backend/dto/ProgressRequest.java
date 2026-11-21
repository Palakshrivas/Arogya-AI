package backend.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProgressRequest {

    @NotBlank
    private String subject;

    @NotBlank
    private String exam;

    @Min(0)
    private Integer questionsAttempted = 0;

    @Min(0)
    private Integer correctAnswers = 0;

    @Min(0)
    private Integer incorrectAnswers = 0;

    @Min(0)
    private Integer studyTimeMinutes = 0;

    public ProgressRequest() {
    }

    public String getSubject() {
        return subject;
    }

    public String getExam() {
        return exam;
    }

    public Integer getQuestionsAttempted() {
        return questionsAttempted;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public Integer getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public Integer getStudyTimeMinutes() {
        return studyTimeMinutes;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setQuestionsAttempted(Integer questionsAttempted) {
        this.questionsAttempted = questionsAttempted;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setIncorrectAnswers(Integer incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setStudyTimeMinutes(Integer studyTimeMinutes) {
        this.studyTimeMinutes = studyTimeMinutes;
    }
}