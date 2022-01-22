package IsBul.proje.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

	 EmployerUpdate getEmployerUpdategetById(int id);
	
	@Transactional
	void deleteEmloyerUpdateById(int id);
}
