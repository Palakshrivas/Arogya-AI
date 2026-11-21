package backend.backend.dto;

import java.time.LocalDateTime;

public record AttemptResponse(
        Long id,
        Long questionId,
        String selectedAnswer,
        String correctAnswer,
        boolean correct,
        LocalDateTime attemptedAt
) {
}