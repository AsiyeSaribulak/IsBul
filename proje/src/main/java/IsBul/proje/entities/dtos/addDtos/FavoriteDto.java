package IsBul.proje.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto {
	 private int id;
	 private int jobSeekerId;
	 private int jobAdvertId;

}
