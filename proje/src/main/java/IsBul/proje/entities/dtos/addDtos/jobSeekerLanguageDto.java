package IsBul.proje.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class jobSeekerLanguageDto {
	  private int id;
	  private int curriculaVitaeId;
      private int languageId;
	  private int languageDegree;
}
