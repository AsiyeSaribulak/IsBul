package IsBul.proje.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import IsBul.proje.Core.services.CloudinaryService;
import IsBul.proje.Core.services.EmailCheckService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.EmailValidator;
import IsBul.proje.Core.utilities.ErrorResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.EmployerService;
import IsBul.proje.dataAccess.abstracts.EmployerDao;
import IsBul.proje.entities.concretes.Employers;

@Service
public class EmployerManager implements EmployerService {
	 private final EmployerDao employerDao;
	    private final CloudinaryService cloudinaryService;
	    private final EmailCheckService emailCheckService;

	    @Autowired
	    public EmployerManager(
	            EmployerDao employerDao,
	            CloudinaryService cloudinaryService,
	            EmailCheckService emailCheckService) {
	        this.employerDao = employerDao;
	        this.cloudinaryService = cloudinaryService;
	        this.emailCheckService = emailCheckService;
	    }
	
	
	@Override
	public DataResult<List<Employers>> getEmployers() {
		   if ((long) this.employerDao.findAll().size() > 0) {
	            return new SuccessDataResult<>(this.employerDao.findAll(), "Success: İş Verenler listelendi!");
	        }

	        return new WarningDataResult<>(this.employerDao.findAll(), "Warning: Maalesef herhangi bir iş veren bulunamadı!");
	    }

	@Override
	public Result addEmployer(Employers employer) {
        String[] employerWebsite = employer.getWebSite().split("\\.", 2);
        String website = employerWebsite[1];

        String[] employerEmail = employer.getEmail().split("@");
        String employerDomain = employerEmail[1];
        try {
            if (!EmailValidator.emailFormatController(employer.getEmail())) {
                return new ErrorResult("Error: Mail formata uygun değil!");
            } else if (!website.contains("www") && !website.contains(".")) {
                return new ErrorResult("Error: Web sitesi formatı uygun değil! (Örn: www.google.com)");
            } else if (!employerDomain.equals(website)) {
                return new ErrorResult("Error: Web sitesi ile email aynı domaine sahip değil!");
            } 
            else {
                this.employerDao.save(employer);
                return new SuccessResult(
                        "Success: İş veren kullanıcı sisteme eklendi, " + emailCheckService.emailValidator(employer));
            }
        } catch (Exception e) {
            if (e.getMessage()
                 .contains("[uc_users_email]")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult("Error: Şirket adı sistem de kayıtlı, lütfen başka bir Şirket adı giriniz!");
            }
        }
    }
	@Override
	public Result updateEmployer(Employers employer) {
		   String[] employerWebsite = employer.getWebSite().split("\\.", 2);
	        String website = employerWebsite[1];

	        String[] employerEmail = employer.getEmail().split("@");
	        String employerDomain = employerEmail[1];
	        try {
	            if (!EmailValidator.emailFormatController(employer.getEmail())) {
	                return new ErrorResult("Error: Mail formata uygun değil!");
	            } else if (!website.contains("www") && !website.contains(".")) {
	                return new ErrorResult("Error: Web sitesi formatı uygun değil! (Örn: www.google.com)");
	            } else if (!employerDomain.equals(website)) {
	                return new ErrorResult("Error: Web sitesi ile email aynı domaine sahip değil!");
	            }  else {
	                this.employerDao.save(employer);
	                return new SuccessResult("Success: İş veren bilgileri güncellendi!");
	            }
	        } catch (Exception e) {
	            if (e.getMessage()
	                 .contains("[uc_users_email]")) {
	                return new ErrorResult("Error:Lütfen başka bir eposta adresi giriniz! Bu Eposta sistemde mevcut");
	            } else {
	                return new ErrorResult("Error:Lütfen başka bir Şirket adı giriniz! Bu şirket adı sistem de kayıtlı");
	            }
	        }
	    }

	@Override
	public Result deleteEmployerById(int employerId) {
        this.employerDao.deletegetEmployersById(employerId);
        return new SuccessResult("Success: Şirket başarılı bir şekilde silindi!");
    }

	@Override
	public DataResult<Employers> getEmployerById(int employerId) {
	    if (this.employerDao.getEmployersById(employerId) == null) {
            return new WarningDataResult<>("Warning: Kayıtlı Şirket bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.employerDao.getEmployersById(employerId),
                    "Success: Şirket listelendi!");
        }
    }

	@Override
	public Result uploadPicture(int employerId, MultipartFile file) throws IOException {
	      var result = this.cloudinaryService.addPicture(file);
	        var url = result.getData().get("url");

	        Employers ref = this.employerDao.getOne(employerId);
	        ref.setPictureUrl(url.toString());
	        this.employerDao.save(ref);

	        return new SuccessResult("Success: Resim eklendi. İşlem başarılı!");
	    }

	@Override
	public Result changeIsUpdated(boolean update, int employerId) {
	      this.employerDao.changeIsUupdated(update, employerId);
	        return new SuccessResult("Success: Şirket bilgilerini güncelledi!");
	    }
	@Override
	public DataResult<List<Employers>> getEmployersByUpdatedTrue() {
	      return new SuccessDataResult<>(
	                this.employerDao.getEmployersByIsUpdateTrue(),
	                "Success: Bilgilerini güncellemek isteyen şirketler listelendi!");
	    }

}
