package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import IsBul.proje.entities.concretes.Employers;

public interface EmployerDao extends JpaRepository<Employers, Integer> {

	Employers getEmployersById(int id);
	
	List<Employers> getEmployersByIsUpdateTrue();
	
	@Transactional
	void deletegetEmployersById(int id);
	
	@Transactional
	@Modifying
	void changeIsUupdated(boolean update, int employerId);
	
}
