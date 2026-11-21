package backend.backend.dto;

import java.time.LocalDateTime;

public record HistoryResponse(
        Long id,
        Long questionId,
        String exam,
        String subject,
        String chapter,
        String selectedAnswer,
        String correctAnswer,
        Boolean correct,
        Integer timeTaken,
        LocalDateTime attemptedAt
) {
}
