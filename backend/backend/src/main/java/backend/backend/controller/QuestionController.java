package backend.backend.controller;

import backend.backend.dto.PageResponse;
import backend.backend.dto.QuestionRequest;
import backend.backend.dto.QuestionResponse;
import backend.backend.enums.Difficulty;
import backend.backend.enums.ExamType;
import backend.backend.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> createQuestion(
            @Valid @RequestBody QuestionRequest request
    ) {
        return ResponseEntity.ok(
                questionService.createQuestion(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getQuestions(
            @RequestParam(required = false) ExamType exam,
            @RequestParam(required = false) Long subjectId,
            @RequestParam(required = false) Long chapterId,
            @RequestParam(required = false) Difficulty difficulty,
            @RequestParam(required = false) String topic
    ) {
        return ResponseEntity.ok(
                questionService.getQuestions(
                        exam,
                        subjectId,
                        chapterId,
                        difficulty,
                        topic
                )
        );
    }

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<PageResponse<QuestionResponse>> getQuestionsByChapter(
            @PathVariable Long chapterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Difficulty difficulty
    ) {
        if (size > 50) {
            size = 50;
        } else if (size < 1) {
            size = 10;
        }

        if (page < 0) {
            page = 0;
        }

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(
                questionService.getQuestionsByChapter(chapterId, difficulty, pageable)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getQuestion(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                questionService.getQuestionById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponse> updateQuestion(
            @PathVariable Long id,
            @Valid @RequestBody QuestionRequest request
    ) {
        return ResponseEntity.ok(
                questionService.updateQuestion(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(
            @PathVariable Long id
    ) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
