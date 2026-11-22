package backend.backend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubjectRequest {

    @NotBlank(message = "Subject name must not be blank")
    private String name;

    @NotNull(message = "Exam type must not be null")
    @JsonAlias({"exam", "examType"})
    private String examType;

    public SubjectRequest() {
    }

    public SubjectRequest(String name, String examType) {
        this.name = name;
        this.examType = examType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExam() {
        return examType;
    }

    public void setExam(String exam) {
        this.examType = exam;
    }
}
