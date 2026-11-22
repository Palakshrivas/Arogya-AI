package backend.backend.dto;

import backend.backend.enums.CorrectOption;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;

public record QuestionResponse(
        Long id,
        String questionText,
        String optionA,
        String optionB,
        String optionC,
        String optionD,
        CorrectOption correctAnswer,
        String explanation,
        ExamType exam,
        Difficulty difficulty,
        String topic,
        Long subjectId,
        String subjectName,
        Long chapterId,
        String chapterName
) {
}
