package backend.backend.mapper;

import backend.backend.dto.SubjectResponse;
import backend.backend.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public SubjectResponse toResponse(Subject subject) {
        if (subject == null) {
            return null;
        }

        return new SubjectResponse(
                subject.getId(),
                subject.getName(),
                subject.getExam()
        );
    }
}
