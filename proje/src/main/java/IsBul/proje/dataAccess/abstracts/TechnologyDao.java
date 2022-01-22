package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{
	List<Technology>  getTechnologieByCVitaeId(int id);
	
	@Transactional
	void deleteTechnologieByCVitaeId(int id);
}
