package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import IsBul.proje.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
