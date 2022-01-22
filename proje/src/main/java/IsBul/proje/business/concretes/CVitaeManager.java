package IsBul.proje.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.services.CloudinaryService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.CVitaeService;
import IsBul.proje.dataAccess.abstracts.CVitaeDao;
import IsBul.proje.entities.concretes.CVitae;
import IsBul.proje.entities.dtos.addDtos.CVitaeDto;
import IsBul.proje.entities.dtos.updateDtos.CVitaeUpdateDto;

@Service
public class CVitaeManager implements CVitaeService {

    private final CVitaeDao cVitaeDao;

    private final CloudinaryService cloudinaryService;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public CVitaeManager(
            CVitaeDao cVitaeDao,
            CloudinaryService cloudinaryService,
            DtoConverterService dtoConverterService) {
        this.cVitaeDao = cVitaeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;

    }

    @Override
    public Result addCv(CVitaeDto cVitae) {
        if (cVitae.getPictureUrl().equals("")) {
            cVitae.setPictureUrl(
                    "https://res.cloudinary.com/asiyesrblk/image/upload/v1641685889/recipes/couple.jpg");
            this.cVitaeDao.save((CVitae) this.dtoConverterService.dtoClassConverter(
                    cVitae,
                    CVitae.class));
            return new SuccessResult("Success: Cv başarıyla eklendi!");
        } else {
            this.cVitaeDao.save((CVitae) this.dtoConverterService.dtoClassConverter(
                    cVitae,
                    CVitae.class));
            return new SuccessResult("Success: Cv başarıyla eklendi!");
        }
    }

    @Override
    public Result updateCv(CVitaeUpdateDto cVitae) {
        if (cVitae.getPictureUrl().equals("")) {
            cVitae.setPictureUrl(
                    "https://res.cloudinary.com/asiyesrblk/image/upload/v1641685889/recipes/couple.jpg");
            this.cVitaeDao.save((CVitae) this.dtoConverterService.dtoClassConverter(
                    cVitae,
                    CVitae.class));
            return new SuccessResult("Success: Cv güncellendi!");
        } else {
            this.cVitaeDao.save((CVitae) this.dtoConverterService.dtoClassConverter(
                    cVitae,
                    CVitae.class));
            return new SuccessResult("Success: Cv güncellendi!");
        }
    }
    
    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");

        CVitae ref = this.cVitaeDao.getOne(cvId);
        ref.setPictureUrl(url.toString());
        this.cVitaeDao.save(ref);

        return new SuccessResult("Success: Resim eklendi!");
}

	@Override
	public DataResult<CVitae> findByJobSeekerId(int jobseekerId) {
		  if (this.cVitaeDao.findByjobSeekerId(jobseekerId) == null) {
	            return new WarningDataResult<>("Warning: Kayıtlı Cv bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.cVitaeDao.findByjobSeekerId(jobseekerId),
	                    "Success: Cv'ler listelendi!");
	        }
	}
}
