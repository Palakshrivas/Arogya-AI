package backend.backend.controller;

import backend.backend.dto.QuestionRequest;
import backend.backend.dto.QuestionResponse;
import backend.backend.service.QuestionService;
import jakarta.validation.Valid;
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
            @RequestParam(required = false) String exam,
            @RequestParam(required = false) Long subjectId,
            @RequestParam(required = false) Long chapterId,
            @RequestParam(required = false) String difficulty,
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
