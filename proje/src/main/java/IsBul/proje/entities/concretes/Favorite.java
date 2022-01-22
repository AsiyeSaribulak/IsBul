package IsBul.proje.entities.concretes;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorites")
public class Favorite {
	@Id
	@NotNull
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	@JoinColumn( name = "jobseeker_id")
	@ManyToOne(cascade = CascadeType.DETACH)
	private jobSeekers jobseeker;
	
	@JoinColumn( name = "job_advert_id")
	@ManyToOne(cascade = CascadeType.DETACH)
	private jobAdversiments jobAdvert;

}
