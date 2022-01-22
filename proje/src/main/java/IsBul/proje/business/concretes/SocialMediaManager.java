package IsBul.proje.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.SocialMediasService;
import IsBul.proje.dataAccess.abstracts.SocialMediaDao;
import IsBul.proje.entities.concretes.SocialMedia;
import IsBul.proje.entities.dtos.addDtos.SocialMediaDto;
import IsBul.proje.entities.dtos.updateDtos.SocialMediaUpdateDto;

@Service
public class SocialMediaManager implements SocialMediasService {
	  private final SocialMediaDao socialMediaDao;
	  private final DtoConverterService dtoConverterService;

	    @Autowired
	    public SocialMediaManager(SocialMediaDao socialMediaDao, DtoConverterService dtoConverterService) {
	        this.socialMediaDao = socialMediaDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	@Override
	public Result addSocialMedia(SocialMediaDto socialMedia) {
	       this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(
	                socialMedia,
	                SocialMedia.class));
	        return new SuccessResult("Success: Sosyal medya bağlantıları başarıyla sisteme eklendi!");
	    }

	@Override
	public Result updateSocialMedia(SocialMediaUpdateDto socialMedia) {
	    this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(
                socialMedia,
                SocialMedia.class));
        return new SuccessResult("Success: Sosyal medya bağlantıları başarıyla güncellendi!");
    }

	@Override
	public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id) {
	       if (this.socialMediaDao.getSocialMediaByCVitaeId(id) == null) {
	            return new WarningDataResult<>("Warning: Listelenecek sosyal hesap bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.socialMediaDao.getSocialMediaByCVitaeId(id),
	                    "Success: Sosyal hesaplar başarıyla listelendi!");
	        }
	    }

}
