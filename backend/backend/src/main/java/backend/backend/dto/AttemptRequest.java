package backend.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AttemptRequest {

    @NotNull
    private Long questionId;

    @NotBlank
    private String selectedAnswer;

    public AttemptRequest() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
