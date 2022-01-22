package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Departmants;

public interface DepartmantService {
	Result addDepartment(Departmants departmant);
    DataResult<List<Departmants>> getAllDepartmant();
}
