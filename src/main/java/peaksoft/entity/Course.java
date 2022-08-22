package peaksoft.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name="duration_month")
    private String durationMonth;

    public Course(String courseName, String durationMonth) {
        this.courseName = courseName;
        this.durationMonth = durationMonth;
    }
     @ManyToOne
    private Company company;
}
