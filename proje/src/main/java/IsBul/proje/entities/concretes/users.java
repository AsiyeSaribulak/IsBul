package IsBul.proje.entities.concretes;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.sun.istack.NotNull;
import javax.persistence.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Inheritance(strategy = InheritanceType.JOINED)
public class users {
	 	@Id
	 	@NotNull
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @NotNull
	    @Column(name = "email")
	    private String email;

	    @NotNull
	    @Column(name = "password")
	    private String password;
	
	
}
