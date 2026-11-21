package backend.backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String exam;

    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Chapter> chapters = new ArrayList<>();

    public Subject() {
    }

    public Subject(String name, String exam) {
        this.name = name;
        this.exam = exam;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExam() {
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

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}