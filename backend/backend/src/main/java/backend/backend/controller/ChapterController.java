package backend.backend.controller;

import backend.backend.dto.ChapterResponse;
import backend.backend.service.ChapterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<ChapterResponse>> getChapters(
            @PathVariable Long subjectId
    ) {

        return ResponseEntity.ok(
                chapterService.getChaptersBySubject(subjectId)
        );
    }

    @PostMapping
    public ResponseEntity<?> createChapter(
            @RequestParam String name,
            @RequestParam Long subjectId
    ) {

        try {
            return ResponseEntity.ok(
                    chapterService.createChapter(
                            name,
                            subjectId
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
