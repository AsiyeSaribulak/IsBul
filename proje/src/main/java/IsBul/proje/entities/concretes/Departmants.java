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
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
public class Departmants {
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    @NotNull
    private String departmentName;

    @JsonIgnore
    @OneToMany(mappedBy = "department" , cascade = CascadeType.DETACH)
    private List<Educations> educations;
}
