package IsBul.proje.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaDto {
	 private int id;
	 private int curriculaVitaeId;
	 private String linkedinUsername;
	 private String githubUsername;

}
