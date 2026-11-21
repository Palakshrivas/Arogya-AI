package backend.backend.controller;

import backend.backend.dto.QuestionRequest;
import backend.backend.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(
            @Valid @RequestBody QuestionRequest request
    ) {

        try {
            return ResponseEntity.ok(
                    questionService.createQuestion(request)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getQuestions(
            @RequestParam(required = false) String exam,
            @RequestParam(required = false) Long subjectId,
            @RequestParam(required = false) Long chapterId,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String topic
    ) {

        try {
            return ResponseEntity.ok(
                    questionService.getQuestions(
                            exam,
                            subjectId,
                            chapterId,
                            difficulty,
                            topic
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(
            @PathVariable Long id
    ) {

        try {
            return ResponseEntity.ok(
                    questionService.getQuestionById(id)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
