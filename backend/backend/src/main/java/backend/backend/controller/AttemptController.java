package backend.backend.controller;

import backend.backend.dto.AttemptRequest;
import backend.backend.service.AttemptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping
    public ResponseEntity<?> submitAttempt(
            Authentication authentication,
            @Valid @RequestBody AttemptRequest request
    ) {
        try {
            return ResponseEntity.ok(
                    attemptService.submitAttempt(
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
    public ResponseEntity<?> getMyAttempts(
            Authentication authentication
    ) {
        try {
            return ResponseEntity.ok(
                    attemptService.getMyAttempts(
                            authentication.getName()
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
