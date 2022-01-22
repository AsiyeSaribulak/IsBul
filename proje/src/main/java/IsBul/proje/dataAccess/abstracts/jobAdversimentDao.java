package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import IsBul.proje.entities.concretes.jobAdversiments;

public interface jobAdversimentDao extends JpaRepository<jobAdversiments, Integer> {
	 	List<jobAdversiments> findAllByIsActiveTrue();

	    List<jobAdversiments> getJobAdvertByEmployer_CompanyName(String companyName, Sort sort);

	    List<jobAdversiments> getJobAdvertByEmployerId(int employerId, Sort sort);

	    List<jobAdversiments> findAllByIsActiveTrue(Sort sort);

	    List<jobAdversiments> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Pageable pageable);

	    List<jobAdversiments> getJobAdvertByIsActiveTrueAndIsConfirmedTrue();

	    @Transactional
	    @Modifying
	    @Query("Update JobAdvert set isActive =:active where id =:jobAdvertId")
	    void changeIsActive(boolean active, int jobAdversimentId);

	    @Transactional
	    @Modifying
	    @Query("Update JobAdvert set isConfirmed =:confirm where id =:jobAdvertId")
	    void changeIsConfirmed(boolean confirm, int jobAdversimentId);

	    jobAdversiments getJobAdversimentById(int id);

	    @Transactional
	    void deleteJobAdversimentById(int id);
}
