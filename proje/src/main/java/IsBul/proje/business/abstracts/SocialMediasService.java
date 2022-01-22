package IsBul.proje.business.abstracts;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.SocialMedia;
import IsBul.proje.entities.dtos.addDtos.SocialMediaDto;
import IsBul.proje.entities.dtos.updateDtos.SocialMediaUpdateDto;

public interface SocialMediasService {
	Result addSocialMedia(SocialMediaDto socialMedia);
    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);
    DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id);
}
