package backend.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "selected_answer", nullable = false)
    private String selectedAnswer;

    @Column(name = "correct", nullable = false)
    private boolean correct;

    @Column(name = "attempted_at", nullable = false)
    private LocalDateTime attemptedAt;

    public Attempt() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public LocalDateTime getAttemptedAt() {
        return attemptedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setAttemptedAt(LocalDateTime attemptedAt) {
        this.attemptedAt = attemptedAt;
    }
}