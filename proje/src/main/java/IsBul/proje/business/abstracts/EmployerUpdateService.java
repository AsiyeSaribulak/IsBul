package IsBul.proje.business.abstracts;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	  DataResult<EmployerUpdate> getEmployerUpdateById(int employerId);

	    Result deleteEmployerUpdateById(int employerId);

	    Result addEmployerUpdate(EmployerUpdate employerUpdate);
}
