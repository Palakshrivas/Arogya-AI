package backend.backend.dto;

public record QuestionResponse(
        Long id,
        String questionText,
        String optionA,
        String optionB,
        String optionC,
        String optionD,
        String correctAnswer,
        String explanation,
        String exam,
        String difficulty,
        String topic,
        Long subjectId,
        String subjectName,
        Long chapterId,
        String chapterName
) {
}