package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.LanguageService;
import IsBul.proje.dataAccess.abstracts.LanguageDao;
import IsBul.proje.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	  private final LanguageDao languageDao;
	    @Autowired
	    public LanguageManager(LanguageDao languageDao) {
	        this.languageDao = languageDao;
	    }
	@Override
	public DataResult<List<Language>> addLanguages(List<Language> languages) {
	      return new SuccessDataResult<>(
	                this.languageDao.saveAll(languages),
	                "Success: Yabancı dil ekleme işlemi başarılı!");
	    }

	@Override
	public DataResult<List<Language>> getLanguages() {
	    if (this.languageDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı yabancı dil bulunamadı!");
        }
        return new SuccessDataResult<>(this.languageDao.findAll(), "Success: Yabancı diller başarıyla listelendi!");

    }

}
