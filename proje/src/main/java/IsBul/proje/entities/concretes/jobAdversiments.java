package IsBul.proje.entities.concretes;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handeler" ,"favorites"})

@Table(name = "job_adverts")
public class jobAdversiments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "salary")
	private int salary;
	
	@NotNull
	@Column(name = "position_count")
	private int positionCount;
	
	@NotNull
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "airdate")
	private LocalDateTime airdate = LocalDateTime.now();
	
	@NotNull
	@Column(name = "uptime")
	private String uptime;
	
	@NotNull
	@Column(name = "type_of_emloyment")
	private String typeOfEmloyment;
	
	@NotNull
	@Column(name = "is_active")
	private boolean isActive = true;
	
	
	@NotNull
	@Column(name = "is_confirmed")
	private boolean isConfirmed = false;
	
	@JoinColumn(name = "employer_id")
	@ManyToOne()
	private Employers employer;
	
	@JoinColumn(name = "job_position_id")
	@ManyToOne()
	private jobPosition jobposition;
	
	@JoinColumn(name = "city_id")
	@ManyToOne()
	private City city;
	
	@OneToMany(mappedBy = "jobAdvert" , cascade = CascadeType.DETACH)
	private List<Favorite> favorites;
	
	
	
	
	
	
	
}
