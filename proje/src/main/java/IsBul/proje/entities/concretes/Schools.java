package IsBul.proje.entities.concretes;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class Schools {
	 @Id
	 @Column(name = "id")
	 @NotNull
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	 @Column(name = "school_name")
	 private String schoolName;

	 @JsonIgnore
	 @OneToMany(mappedBy = "school", cascade = CascadeType.DETACH)
	 private List<Educations> educations;
}
