package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.DepartmantService;
import IsBul.proje.dataAccess.abstracts.DepartmantDao;
import IsBul.proje.entities.concretes.Departmants;

@Service
public class DepartmantManager implements DepartmantService {
	private final DepartmantDao departmantDao;

    @Autowired
    public DepartmantManager(DepartmantDao departmentDao) {
        this.departmantDao = departmentDao;
    }

  

    @Override
    public DataResult<List<Departmants>> getAllDepartmant() {
        if (this.departmantDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı bölüm bulunamadı!");
        } else {
            return new DataResult<>(this.departmantDao.findAll(), "Success: Bölümler başarıyla listelendi!");
        }
    }

	@Override
	public Result addDepartment(Departmants departmant) {
		this.departmantDao.save(departmant);
        return new SuccessResult("Success: Bölüm eklendi!");
	}

}
