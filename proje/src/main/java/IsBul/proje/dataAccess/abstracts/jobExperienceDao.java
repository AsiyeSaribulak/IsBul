package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.jobExperience;

public interface jobExperienceDao extends JpaRepository<jobExperience, Integer>{
	List<jobExperience>  getJobExperienceEndDateByCurriculaVitaeId(int id, Sort sort);
	@Transactional
	void deleteJobExperienceById(int id);
}
