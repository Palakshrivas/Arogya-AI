package backend.backend.controller;

import backend.backend.dto.HistoryRequest;
import backend.backend.service.HistoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<?> createHistory(
            Authentication authentication,
            @Valid @RequestBody HistoryRequest request
    ) {

        try {

            return ResponseEntity.ok(
                    historyService.createHistory(
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
    public ResponseEntity<?> getHistory(
            Authentication authentication,
            @RequestParam(required = false) String exam
    ) {

        try {

            return ResponseEntity.ok(
                    historyService.getHistory(
                            authentication.getName(),
                            exam
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}