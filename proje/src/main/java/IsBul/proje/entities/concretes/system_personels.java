package IsBul.proje.entities.concretes;

import lombok.Data;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="system_personels",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})} )
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class system_personels extends users {
	@Column(name ="username")
	@NotNull
	private String user_name;
}
