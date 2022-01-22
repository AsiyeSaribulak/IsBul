package IsBul.proje.entities.concretes;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@JsonIgnoreProperties({"hibernateLazyInnitializer " , "handler", "curriculaVitae"})

public class jobExperience {

	@Id
	@NotNull
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = " company_name")
	private String companyName;
	
	
	@Column(name = " position_name")
	private String positionName;
	
	
	@Column(name = "Star_date")
    @NotNull
    @NotBlank
    private LocalDate startDate;
	
	
	@Column(name = " end_date")
	private LocalDate endDate;
	
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "curricula_vitae_id")
	private CVitae curriculaVitae;
	
	
}
