package IsBul.proje.entities.dtos.addDtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	 private int id;
     private int curriculaVitaeId;
	 private int schoolId;
	 private int departmentId;
	 private LocalDate startDate;
	 private LocalDate endDate;
}
