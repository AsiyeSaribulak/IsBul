package IsBul.proje.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.jobSeekers;

public interface jobSeekerDao extends JpaRepository<jobSeekers, Integer> {
	jobSeekers  getjobSeekerById(int id);
	
	@Transactional
	void deletejobSeekerById(int id);
}
