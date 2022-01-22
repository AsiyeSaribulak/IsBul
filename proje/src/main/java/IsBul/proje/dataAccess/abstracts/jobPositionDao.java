package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.jobPosition;

public interface jobPositionDao extends JpaRepository<jobPosition, Integer> {

}
