package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.jobSeekerLanguage;

public interface jobSeekerLanguageDao extends JpaRepository<jobSeekerLanguage, Integer>{
	List<jobSeekerLanguage>  getjobSeekerLanguageByCVitaeId(int id);
	
	@Transactional
	void deletejobSeekerLanguageById(int id);
}
