package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.EducationService;
import IsBul.proje.dataAccess.abstracts.EducationsDao;
import IsBul.proje.entities.concretes.Educations;
import IsBul.proje.entities.dtos.addDtos.EducationDto;

@Service
public class EducationManager implements EducationService {

	private final DtoConverterService dtoConverterService;
    private final EducationsDao educationDao;

    @Autowired
    public EducationManager(EducationsDao educationDao, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }
    
	@Override
	public Result addEducation(EducationDto education) {
		  this.educationDao.save((Educations) this.dtoConverterService.dtoClassConverter(education, Educations.class));
	        return new SuccessResult("Success: Eğitim bilgileri eklendi!...BAŞARILI");
	    }

	@Override
	public DataResult<List<Educations>> getAllEducations() {
		  if (this.educationDao.findAll().isEmpty()) {
	            return new WarningDataResult<>("Warning: Listelenecek bir eğitim bilgisi bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.educationDao.findAll(),
	                    "Success: Tüm eğitim bilgileri listelendi!...BAŞARILI");
	        }
	    }
	@Override
	public DataResult<List<Educations>> getEducationsByCvId(int id) {
	     Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
	        if (this.educationDao.getEducationsEndDateByCVitaeId(id, sort).isEmpty()) {
	            return new WarningDataResult<>("Warning: Listelenecek eğitim bilgisi bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.educationDao.getEducationsEndDateByCVitaeId(id, sort),
	                    "Success: Eğitim geçmişi sıralanıp listelendi!...BAŞARILI");
	        }
	    }

	@Override
	public Result deleteEducationById(int id) {
	     this.educationDao.deleteEducationById(id);
	        return new SuccessResult("Success: Eğitim bilgisi silindi!...BAŞARILI");
	    }
}
