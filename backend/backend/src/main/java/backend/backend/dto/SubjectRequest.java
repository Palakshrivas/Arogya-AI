package backend.backend.dto;

import backend.backend.enums.ExamType;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubjectRequest {

    @NotBlank(message = "Subject name must not be blank")
    private String name;

    @NotNull(message = "Exam type must not be null")
    @JsonAlias({"exam", "examType"})
    private ExamType examType;

    public SubjectRequest() {
    }

    public SubjectRequest(String name, ExamType examType) {
        this.name = name;
        this.examType = examType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
