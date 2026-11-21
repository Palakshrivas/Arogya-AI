package backend.backend.controller;

import backend.backend.dto.SubjectResponse;
import backend.backend.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponse>> getSubjects(
            @RequestParam(required = false) String exam
    ) {

        return ResponseEntity.ok(
                subjectService.getAllSubjects(exam)
        );
    }

    @PostMapping
    public ResponseEntity<?> createSubject(
            @RequestParam String name,
            @RequestParam String exam
    ) {

        try {
            return ResponseEntity.ok(
                    subjectService.createSubject(name, exam)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
