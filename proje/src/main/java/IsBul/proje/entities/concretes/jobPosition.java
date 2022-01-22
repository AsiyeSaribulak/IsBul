package IsBul.proje.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions ", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_title"})})
public class jobPosition {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_title")
	@NotNull
	private String jobTitle;
	
	@OneToMany(mappedBy = "job_position")
	@JsonIgnore
	private List<jobAdversiments> jobAdvert;
	
	 
	
}
