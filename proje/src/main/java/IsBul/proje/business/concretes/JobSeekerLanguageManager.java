package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.JobseekerLanguageService;
import IsBul.proje.dataAccess.abstracts.jobSeekerLanguageDao;
import IsBul.proje.entities.concretes.jobSeekerLanguage;
import IsBul.proje.entities.dtos.addDtos.jobSeekerLanguageDto;

@Service
public class JobSeekerLanguageManager implements JobseekerLanguageService  {
    private final jobSeekerLanguageDao jobSeekerLanguagesDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobSeekerLanguageManager(
    		jobSeekerLanguageDao jobSeekerLanguagesDao,
            DtoConverterService dtoConverterService) {
        this.jobSeekerLanguagesDao = jobSeekerLanguagesDao;
        this.dtoConverterService = dtoConverterService;
    }
	@Override
	public Result addJobSeekerLanguage(jobSeekerLanguageDto jobSeekerLanguage) {
	     this.jobSeekerLanguagesDao.save((jobSeekerLanguage) this.dtoConverterService.dtoClassConverter(
	                jobSeekerLanguage,
	                jobSeekerLanguageDao.class));
	        return new SuccessResult("Success: Cv'ye başarıyla yabancı dil bilgisi eklendi!");
	    }

	@Override
	public DataResult<List<jobSeekerLanguage>> getJobSeekerLanguageByCurriculaVitaeId(int id) {
	     if (this.jobSeekerLanguagesDao.getjobSeekerLanguageByCVitaeId(id).isEmpty()) {
	            return new WarningDataResult<>("Warning: Listelenecek yabancı dil bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.jobSeekerLanguagesDao.getjobSeekerLanguageByCVitaeId(id),
	                    "Success: Yabancı diller listelendi!");
	        }
	    }

	@Override
	public Result deleteJobSeekerLanguageById(int id) {
	    this.jobSeekerLanguagesDao.deletejobSeekerLanguageById(id);
        return new SuccessResult("Success: Yabancı dil bilgisi silindi!");
    }

}
