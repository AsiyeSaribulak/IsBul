package IsBul.proje.entities.dtos.addDtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class jobExperienceDto {
	private int id;
    private int curriculaVitaeId;
    private String companyName;
    private String positionName;
    private LocalDate startDate;
    private LocalDate endDate;
}
