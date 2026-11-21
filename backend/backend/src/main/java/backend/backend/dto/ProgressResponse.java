package backend.backend.dto;

import java.time.LocalDateTime;

public record ProgressResponse(
        Long id,
        String subject,
        String exam,
        Integer questionsAttempted,
        Integer correctAnswers,
        Integer incorrectAnswers,
        Double accuracy,
        Integer studyTimeMinutes,
        LocalDateTime lastUpdated
) {
}