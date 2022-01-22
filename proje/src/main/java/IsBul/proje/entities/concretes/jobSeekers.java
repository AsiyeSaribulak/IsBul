package IsBul.proje.entities.concretes;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculaVitaes", "favorites"})

public class jobSeekers extends users {
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Column(name = "identity_number")
	private String identityNumber;

	@NotNull
	@Column(name = "birth_day")
	private LocalDate birtDay;
	
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
	 private List<CVitae> curriculaVitaes;

	 @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
	 private List<Favorite> favorites;
	
	
	
	
	
	
	
}
