package IsBul.proje.entities.concretes;

import java.util.List;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curricula_vitaes")
public class CVitae {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "picture_url")  /****VERİTABANINDA HATA VERİYOR.daha sonra tekrar incele****/
    private String pictureUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private jobSeekers jobSeeker;

    @OneToOne(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private SocialMedia socialMedia;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Educations> educations;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<jobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<jobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "curriculaVitae", cascade = CascadeType.DETACH)
    private List<Technology> technologies;
}