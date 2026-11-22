package backend.backend.entity;

import backend.backend.enums.ExamType;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExamType exam;

    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Chapter> chapters = new ArrayList<>();

    public Subject() {
    }

    public Subject(String name, ExamType exam) {
        this.name = name;
        this.exam = exam;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ExamType getExam() {
        return exam;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExam(ExamType exam) {
        this.exam = exam;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
