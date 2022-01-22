package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.ErrorResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.SystemPersonService;
import IsBul.proje.dataAccess.abstracts.SystemPersonelDao;
import IsBul.proje.entities.concretes.system_personels;

@Service
public class SystemPersonelManager implements SystemPersonService {
	 SystemPersonelDao systemPersonelDao;

	 @Autowired
	  public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
	      this.systemPersonelDao = systemPersonelDao;
	    }
	 
	@Override
	public DataResult<List<system_personels>> getSystemPersonels() {
	    if ((long) this.systemPersonelDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.systemPersonelDao.findAll(), "Success: Personeller listelendi!");
        }

        return new WarningDataResult<>(this.systemPersonelDao.findAll(), "Herhangi bir personel bulunamadı!");
    }

	@Override
	public Result addSystemPersonel(system_personels systemPersonel) {
	     try {
	            this.systemPersonelDao.save(systemPersonel);
	            return new SuccessResult("Success: Personel başarıyla eklendi!");
	        } catch (Exception e) {
	            if (e.getMessage()
	                 .contains("[uc_users_email]")) {
	                return new ErrorResult("Error: Bu Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
	            } else {
	                return new ErrorResult(
	                        "Error: Bu Kullanıcı adı sistem de kayıtlı, lütfen başka bir kullanıcı adı giriniz!");
	            }
	        }
	    }

	@Override
	public Result updateSystemPersonel(system_personels systemPersonel) {
	     try {
	            this.systemPersonelDao.save(systemPersonel);
	            return new SuccessResult("Success: Personel başarıyla güncellendi!");
	        } catch (Exception e) {
	            if (e.getMessage()
	                 .contains("[uc_users_email]")) {
	                return new ErrorResult("Error: Bu Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
	            } else {
	                return new ErrorResult(
	                        "Error: Bu Kullanıcı adı sistem de kayıtlı, lütfen başka bir kullanıcı adı giriniz!");
	            }
	        }
	    }

	@Override
	public DataResult<system_personels> getsystem_personelsById(int systemPersonelId) {
		  if (this.systemPersonelDao.getsystem_personelById(systemPersonelId) == null) {
	            return new WarningDataResult<>("Warning: Kayıtlı Personel bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.systemPersonelDao.getsystem_personelById(systemPersonelId),
	                    "Success: Personel listelendi!");
	        }
	    }

	@Override
	public Result deletesystem_personelsById(int systemPersonelId) {
	    this.systemPersonelDao.deletesystem_personelById(systemPersonelId);
        return new SuccessResult("Success: Personel silindi!");
    }
}


