package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Schools;

public interface SchoolService {
	 Result addSchool(Schools school);
	 DataResult<List<Schools>> getAllSchool();
}
