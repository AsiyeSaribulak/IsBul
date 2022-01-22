package IsBul.proje.business.abstracts;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Employers;

public interface EmployerService {
	  DataResult<List<Employers>> getEmployers();

	    Result addEmployer(Employers employer);

	    Result updateEmployer(Employers employer);

	    Result deleteEmployerById(int employerId);

	    DataResult<Employers> getEmployerById(int employerId);

	    Result uploadPicture(int employerId, MultipartFile file) throws IOException;

	    Result changeIsUpdated(boolean update, int employerId);

	    DataResult<List<Employers>> getEmployersByUpdatedTrue();
}
