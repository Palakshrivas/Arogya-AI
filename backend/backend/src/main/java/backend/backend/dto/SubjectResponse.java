package backend.backend.dto;

import backend.backend.enums.ExamType;

public record SubjectResponse(
        Long id,
        String name,
        ExamType exam
) {
}
