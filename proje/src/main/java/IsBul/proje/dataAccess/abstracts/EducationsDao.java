package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.Educations;

public interface EducationsDao extends JpaRepository<Educations, Integer> {
 List<Educations> getEducationsEndDateByCVitaeId(int id, Sort sort);
 
 @Transactional
 void deleteEducationById(int id);
}
