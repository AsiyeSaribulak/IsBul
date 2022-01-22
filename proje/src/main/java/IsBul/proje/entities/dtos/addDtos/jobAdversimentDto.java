package IsBul.proje.entities.dtos.addDtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class jobAdversimentDto {
	    private int id;
	    private int employerId;
	    private int cityId;
	    private int jobPositionId;
	    private String description;
	    private LocalDate deadline;
	    private String uptime;
	    private String typeOfEmployement;
	    private int positionCount;
	    private int salary;

}
