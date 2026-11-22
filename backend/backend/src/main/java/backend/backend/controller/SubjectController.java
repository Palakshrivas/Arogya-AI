package backend.backend.controller;

import backend.backend.dto.SubjectRequest;
import backend.backend.dto.SubjectResponse;
import backend.backend.service.SubjectService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> getSubject(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                subjectService.getSubjectById(id)
        );
    }

    @PostMapping
    public ResponseEntity<SubjectResponse> createSubject(
            @Valid @RequestBody SubjectRequest request
    ) {
        return ResponseEntity.ok(
                subjectService.createSubject(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponse> updateSubject(
            @PathVariable Long id,
            @Valid @RequestBody SubjectRequest request
    ) {
        return ResponseEntity.ok(
                subjectService.updateSubject(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(
            @PathVariable Long id
    ) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
