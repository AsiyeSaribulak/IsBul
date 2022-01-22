package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.Schools;

public interface SchoolDao extends JpaRepository<Schools, Integer> {

}
