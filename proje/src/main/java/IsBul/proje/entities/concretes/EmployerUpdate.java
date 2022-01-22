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
@Table(name = "employers_update", uniqueConstraints = {@UniqueConstraint(columnNames = {"campany_name"})})
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

	@Id
	@NotNull
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@Column(name = "website")
	private String webSite;
	
	@NotNull
	@Column(name = "phone_number")
	private String PhoneNumber;
	
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "password")
	private String pasword;
}
