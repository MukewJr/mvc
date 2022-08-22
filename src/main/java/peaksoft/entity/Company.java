package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(generator = "company_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen",
            sequenceName = "company_seq",allocationSize = 1)
    private long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name="located_country")
    private String locatedCountry;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "company")
    private List<Course> courses;

}
