package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import IsBul.proje.entities.concretes.Departmants;

public interface DepartmantDao extends JpaRepository<Departmants, Integer> {

}
