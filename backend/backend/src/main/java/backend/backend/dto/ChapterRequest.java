package backend.backend.dto;

import backend.backend.enums.Difficulty;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ChapterRequest {

    @NotBlank(message = "Chapter name must not be blank")
    private String name;

    @NotNull(message = "Subject ID must not be null")
    @Positive(message = "Subject ID must be positive")
    private Long subjectId;

    @NotNull(message = "Difficulty level must not be null")
    @JsonAlias({"difficulty", "difficultyLevel"})
    private Difficulty difficultyLevel;

    @Min(value = 0, message = "Display order must be 0 or greater")
    private Integer displayOrder;

    public ChapterRequest() {
    }

    public ChapterRequest(String name, Long subjectId, Difficulty difficultyLevel, Integer displayOrder) {
        this.name = name;
        this.subjectId = subjectId;
        this.difficultyLevel = difficultyLevel;
        this.displayOrder = displayOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Difficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Difficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Difficulty getDifficulty() {
        return difficultyLevel;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficultyLevel = difficulty;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
