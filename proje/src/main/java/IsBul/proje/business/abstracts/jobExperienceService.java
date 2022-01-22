package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobExperience;
import IsBul.proje.entities.dtos.addDtos.jobExperienceDto;

public interface jobExperienceService {
	Result addJobExperience(jobExperienceDto jobExperience);

    DataResult<List<jobExperience>> getjobExperienceByCvId(int id);

    Result deleteJobExperienceById(int id);
}
