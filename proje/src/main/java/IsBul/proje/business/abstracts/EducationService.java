package IsBul.proje.business.abstracts;

import java.util.List;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Educations;
import IsBul.proje.entities.dtos.addDtos.EducationDto;

public interface EducationService {
	Result addEducation(EducationDto education);
    DataResult<List<Educations>> getAllEducations();
    DataResult<List<Educations>> getEducationsByCvId(int id);
    Result deleteEducationById(int id);
}
