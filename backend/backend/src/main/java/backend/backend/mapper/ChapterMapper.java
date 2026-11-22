package backend.backend.mapper;

import backend.backend.dto.ChapterResponse;
import backend.backend.entity.Chapter;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {

    public ChapterResponse toResponse(Chapter chapter) {
        if (chapter == null) {
            return null;
        }

        return new ChapterResponse(
                chapter.getId(),
                chapter.getName(),
                chapter.getSubject() != null ? chapter.getSubject().getId() : null,
                chapter.getSubject() != null ? chapter.getSubject().getName() : null
        );
    }
}
