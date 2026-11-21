package backend.backend.controller;

import backend.backend.dto.MistakeRequest;
import backend.backend.service.MistakeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mistakes")
public class MistakeController {

    private final MistakeService mistakeService;

    public MistakeController(MistakeService mistakeService) {
        this.mistakeService = mistakeService;
    }

    @PostMapping
    public ResponseEntity<?> createMistake(
            Authentication authentication,
            @Valid @RequestBody MistakeRequest request
    ) {

        try {

            return ResponseEntity.ok(
                    mistakeService.createMistake(
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
    public ResponseEntity<?> getMistakes(
            Authentication authentication,
            @RequestParam(required = false) String exam
    ) {

        try {

            return ResponseEntity.ok(
                    mistakeService.getMistakes(
                            authentication.getName(),
                            exam
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMistake(
            Authentication authentication,
            @PathVariable Long id
    ) {

        try {

            mistakeService.deleteMistake(
                    authentication.getName(),
                    id
            );

            return ResponseEntity.ok(
                    "Mistake deleted successfully"
            );

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }
}