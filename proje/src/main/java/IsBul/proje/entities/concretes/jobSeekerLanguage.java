package IsBul.proje.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculaVitaes"})
public class jobSeekerLanguage {
	

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "language_degree")
    @Min(1)
    @Max(5)
    @NotNull
    @NotBlank
    private int languageDegree;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curricula_vitae_id")
    private CVitae curriculaVitae;
	

}
