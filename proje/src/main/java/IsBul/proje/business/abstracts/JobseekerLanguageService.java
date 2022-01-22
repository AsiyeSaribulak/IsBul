package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobSeekerLanguage;
import IsBul.proje.entities.dtos.addDtos.jobSeekerLanguageDto;

public interface JobseekerLanguageService {
	 Result addJobSeekerLanguage(jobSeekerLanguageDto jobSeekerLanguage);
     DataResult<List<jobSeekerLanguage>> getJobSeekerLanguageByCurriculaVitaeId(int id);
	 Result deleteJobSeekerLanguageById(int id);
}
