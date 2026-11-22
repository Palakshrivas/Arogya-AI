package backend.backend.controller;

import backend.backend.dto.ChapterRequest;
import backend.backend.dto.ChapterResponse;
import backend.backend.service.ChapterService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<ChapterResponse> getChapter(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                chapterService.getChapterById(id)
        );
    }

    @PostMapping
    public ResponseEntity<ChapterResponse> createChapter(
            @Valid @RequestBody ChapterRequest request
    ) {
        return ResponseEntity.ok(
                chapterService.createChapter(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapterResponse> updateChapter(
            @PathVariable Long id,
            @Valid @RequestBody ChapterRequest request
    ) {
        return ResponseEntity.ok(
                chapterService.updateChapter(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(
            @PathVariable Long id
    ) {
        chapterService.deleteChapter(id);
        return ResponseEntity.noContent().build();
    }
}
