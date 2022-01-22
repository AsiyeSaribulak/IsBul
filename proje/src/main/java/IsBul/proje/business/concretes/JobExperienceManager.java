package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import IsBul.proje.business.abstracts.jobExperienceService;
import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.dataAccess.abstracts.jobExperienceDao;
import IsBul.proje.entities.concretes.jobExperience;
import IsBul.proje.entities.dtos.addDtos.jobExperienceDto;
@Service
public class JobExperienceManager implements jobExperienceService{
	    private final jobExperienceDao jobExperiencesDao;
	    private final DtoConverterService dtoConverterService;
	    @Autowired
	    public JobExperienceManager(jobExperienceDao jobExperiencesDao, DtoConverterService dtoConverterService) {
	        this.jobExperiencesDao = jobExperiencesDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	@Override
	public Result addJobExperience(jobExperienceDto jobExperience) {
	     this.jobExperiencesDao.save((jobExperience) this.dtoConverterService.dtoClassConverter(
	                jobExperience,
	                jobExperience.class));
	        return new SuccessResult("Success: Kariyer bilgisi sisteme eklendi!");
	    }

	@Override
	public DataResult<List<jobExperience>> getjobExperienceByCvId(int id) {
		   Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
	        if (this.jobExperiencesDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort).isEmpty()) {
	            return new WarningDataResult<>("Warning: Listelenecek iş tecrübesi bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.jobExperiencesDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort),
	                    "Success: İş tecrübeleri sıralanıp listelendi!");
	        }
	    }
	@Override
	public Result deleteJobExperienceById(int id) {
	    this.jobExperiencesDao.deleteJobExperienceById(id);
        return new SuccessResult("Success: İş geçmişi silindi!");
    }

}
