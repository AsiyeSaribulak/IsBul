package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.services.EmailCheckService;
import IsBul.proje.Core.services.MernisCheckService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.EmailValidator;
import IsBul.proje.Core.utilities.ErrorResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.JobSeekerService;
import IsBul.proje.dataAccess.abstracts.jobSeekerDao;
import IsBul.proje.entities.concretes.jobSeekers;

@Service
public class JobSeekerManager implements JobSeekerService {
	private final jobSeekerDao jobSeekersDao;
    private final MernisCheckService mernisCheckService;
    private final EmailCheckService emailCheckService;

    @Autowired
    public JobSeekerManager( jobSeekerDao jobSeekesrDao,MernisCheckService mernisCheckService,EmailCheckService emailCheckService) {
        this.jobSeekersDao = jobSeekesrDao;
        this.mernisCheckService = mernisCheckService;
        this.emailCheckService = emailCheckService;
    }
	@Override
	public DataResult<List<jobSeekers>> getJobSeekers() {
		 if ((long) this.jobSeekersDao.findAll().size() > 0) {
	            return new SuccessDataResult<>(this.jobSeekersDao.findAll(), "Success: İş Arayanlar listelendi!");
	        }

	        return new WarningDataResult<>(this.jobSeekersDao.findAll(), "Warning: Herhangi bir iş arayan bulunamadı!");
	    }

	@Override
	public Result addJobSeeker(jobSeekers jobSeeker) {
	       try {
	            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
	                return new ErrorResult("Error: Mail formata uygun değil!");
	            } else if (!mernisCheckService.isMernis(jobSeeker)) {
	                return new ErrorResult("Error: Gerçek bir kişi değil!");
	            } else {
	                this.jobSeekersDao.save(jobSeeker);
	                return new SuccessResult(
	                        "Success: İş arayan kullanıcı sisteme eklendi, " + emailCheckService.emailValidator(jobSeeker));
	            }
	        } catch (Exception e) {
	            if (e.getMessage()
	                 .contains("[uc_users_email]")) {
	                return new ErrorResult("Error:  Bu Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
	            } else {
	                return new ErrorResult(
	                        "Error: Bu kimlik numarası sistem de kayıtlı, lütfen başka bir kimlik numarası giriniz!");
	            }
	        }
	    }

	@Override
	public Result deleteJobSeekerById(int jobSeekerId) {
	    this.jobSeekersDao.deletejobSeekerById(jobSeekerId);
        return new SuccessResult("Success: İş arayan silindi!");
    }

	@Override
	public DataResult<jobSeekers> getJobSeekerById(int jobSeekerId) {
		   if (this.jobSeekersDao.getjobSeekerById(jobSeekerId) == null) {
	            return new WarningDataResult<>("Warning: Kayıtlı İş Arayan bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.jobSeekersDao.getjobSeekerById(jobSeekerId),
	                    "Success: İş Arayan listelendi!");
	        }
	    }

}
