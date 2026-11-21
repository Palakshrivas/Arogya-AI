package backend.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false)
    private String exam;

    @Column(nullable = false)
    private String subject;

    private String chapter;

    private String selectedAnswer;

    private String correctAnswer;

    @Column(nullable = false)
    private Boolean correct;

    private Integer timeTaken;

    @Column(nullable = false)
    private LocalDateTime attemptedAt;

    public History() {
    }

    @PrePersist
    protected void onCreate() {
        if (attemptedAt == null) {
            attemptedAt = LocalDateTime.now();
        }
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

    public String getExam() {
        return exam;
    }

    public String getSubject() {
        return subject;
    }

    public String getChapter() {
        return chapter;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public Integer getTimeTaken() {
        return timeTaken;
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

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setAttemptedAt(LocalDateTime attemptedAt) {
        this.attemptedAt = attemptedAt;
    }
}