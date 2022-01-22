package IsBul.proje.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.EmployerUpdateService;
import IsBul.proje.dataAccess.abstracts.EmployerUpdateDao;
import IsBul.proje.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{
    private final EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }
	
	
	
	@Override
	public DataResult<EmployerUpdate> getEmployerUpdateById(int employerId) {
		   if (this.employerUpdateDao.getEmployerUpdategetById(employerId) == null) {
	            return new WarningDataResult<>("Warning: Kayıtlı Şirket bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.employerUpdateDao.getEmployerUpdategetById(employerId),
	                    "Success: Şirket başarıyla listelendi!");
	        }
	    }
	@Override
	public Result deleteEmployerUpdateById(int employerId) {
		   this.employerUpdateDao.deleteEmloyerUpdateById(employerId);
	        return new SuccessResult("Success: Şirket silindi!");
	    }

	@Override
	public Result addEmployerUpdate(EmployerUpdate employerUpdate) {
	     this.employerUpdateDao.save(employerUpdate);
	        return new SuccessResult("Success: Şirket eklendi!");
	    }

}
