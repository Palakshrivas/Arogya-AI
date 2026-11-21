package backend.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "progress",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_progress_user_subject_exam",
                        columnNames = {"user_id", "subject", "exam"}
                )
        }
)
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String exam;

    @Column(nullable = false)
    private Integer questionsAttempted = 0;

    @Column(nullable = false)
    private Integer correctAnswers = 0;

    @Column(nullable = false)
    private Integer incorrectAnswers = 0;

    @Column(nullable = false)
    private Double accuracy = 0.0;

    private Integer studyTimeMinutes = 0;

    private LocalDateTime lastUpdated;

    public Progress() {
    }

    @PrePersist
    @PreUpdate
    protected void updateAccuracyAndTime() {

        int attempted = questionsAttempted == null
                ? 0
                : questionsAttempted;

        int correct = correctAnswers == null
                ? 0
                : correctAnswers;

        accuracy = attempted == 0
                ? 0.0
                : (correct * 100.0) / attempted;

        if (lastUpdated == null) {
            lastUpdated = LocalDateTime.now();
        } else {
            lastUpdated = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getSubject() {
        return subject;
    }

    public String getExam() {
        return exam;
    }

    public Integer getQuestionsAttempted() {
        return questionsAttempted;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public Integer getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public Integer getStudyTimeMinutes() {
        return studyTimeMinutes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setQuestionsAttempted(Integer questionsAttempted) {
        this.questionsAttempted = questionsAttempted;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setIncorrectAnswers(Integer incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public void setStudyTimeMinutes(Integer studyTimeMinutes) {
        this.studyTimeMinutes = studyTimeMinutes;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}