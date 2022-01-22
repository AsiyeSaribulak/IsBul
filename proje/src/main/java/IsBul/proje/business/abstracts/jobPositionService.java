package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobPosition;

public interface jobPositionService {
	   DataResult<List<jobPosition>> getPositions();
	   Result addJobPosition(jobPosition jobPositions);
}
