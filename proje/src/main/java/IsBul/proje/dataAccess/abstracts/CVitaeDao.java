package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import IsBul.proje.entities.concretes.CVitae;

public interface CVitaeDao extends JpaRepository<CVitae, Integer>{
 
	CVitae findByjobSeekerId(int id);
}
