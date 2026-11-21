package backend.backend.controller;

import backend.backend.dto.ProgressRequest;
import backend.backend.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping
    public ResponseEntity<?> saveProgress(
            Authentication authentication,
            @Valid @RequestBody ProgressRequest request
    ) {

        try {

            return ResponseEntity.ok(
                    progressService.saveOrUpdate(
                            authentication.getName(),
                            request
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getProgress(
            Authentication authentication
    ) {

        try {

            return ResponseEntity.ok(
                    progressService.getAll(
                            authentication.getName()
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/subject")
    public ResponseEntity<?> getSubjectProgress(
            Authentication authentication,
            @RequestParam String subject,
            @RequestParam String exam
    ) {

        try {

            return ResponseEntity.ok(
                    progressService.getBySubject(
                            authentication.getName(),
                            subject,
                            exam
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }
}