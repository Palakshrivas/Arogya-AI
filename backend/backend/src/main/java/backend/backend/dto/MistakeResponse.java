package backend.backend.dto;

import java.time.LocalDateTime;

public record MistakeResponse(
        Long id,
        Long questionId,
        String questionText,
        String exam,
        String subject,
        String chapter,
        String selectedAnswer,
        String correctAnswer,
        String explanation,
        LocalDateTime createdAt
) {
}
