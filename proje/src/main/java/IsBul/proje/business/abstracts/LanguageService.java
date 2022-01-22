package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.entities.concretes.Language;

public interface LanguageService {
	  DataResult<List<Language>> addLanguages(List<Language> languages);
	  DataResult<List<Language>> getLanguages();
}
