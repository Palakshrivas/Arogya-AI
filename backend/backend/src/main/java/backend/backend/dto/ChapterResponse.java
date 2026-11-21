package backend.backend.dto;

public record ChapterResponse(
        Long id,
        String name,
        Long subjectId,
        String subjectName
) {
}