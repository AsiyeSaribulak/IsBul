package IsBul.proje.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVitaeUpdateDto {
	    private int id;
	    private int jobSeekerId;
	    private String pictureUrl;
	    private String coverLetter = "";


}
