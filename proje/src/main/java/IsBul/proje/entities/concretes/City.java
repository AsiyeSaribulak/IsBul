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
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name")
    @NotNull
    private String cityName;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<jobAdversiments> jobAdverts;
}
