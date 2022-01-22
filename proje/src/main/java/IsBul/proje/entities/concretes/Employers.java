package IsBul.proje.entities.concretes;


import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers" , uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
public class Employers extends users {


	@NotNull
	@Column(name = "company_name")
	private String companyName;
	 
	@NotNull
	@Column(name = "webSite")
	private String webSite;
	 
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "picture_url")
    private String pictureUrl ="https://res.cloudinary.com/asiyesrblk/image/upload/https://res.cloudinary.com/asiyesrblk/image/upload/v1641685889/recipes/couple.jpg";

	@NotNull
	@Column(name = "is_updated")
	private boolean isUpdate= false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<jobAdversiments> adverts;

}
