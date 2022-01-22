package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.SchoolService;
import IsBul.proje.dataAccess.abstracts.SchoolDao;
import IsBul.proje.entities.concretes.Schools;

@Service
public class SchoolManager implements SchoolService {
	  private final SchoolDao schoolDao;

	    @Autowired
	    public SchoolManager(SchoolDao schoolDao) {
	        this.schoolDao = schoolDao;
	    }
	@Override
	public Result addSchool(Schools school) {
	      this.schoolDao.save(school);
	        return new SuccessResult("Success: Okul başarıyla eklendi!");
	    }

	@Override
	public DataResult<List<Schools>> getAllSchool() {
		  if (this.schoolDao.findAll().isEmpty()) {
	            return new WarningDataResult<>("Warning: Kayıtlı okul bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(this.schoolDao.findAll(), "Success: Bütün okullar listelendi!");
	        }
	    }
}
