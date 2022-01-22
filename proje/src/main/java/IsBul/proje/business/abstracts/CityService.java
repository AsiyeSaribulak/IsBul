package IsBul.proje.business.abstracts;



import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.entities.concretes.City;

public interface CityService {
    DataResult<List<City>> getCities();

}
