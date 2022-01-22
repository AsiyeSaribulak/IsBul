package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.CityService;
import IsBul.proje.dataAccess.abstracts.CityDao;
import IsBul.proje.entities.concretes.City;

@Service
public class CityManager implements CityService{
    private final CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getCities() {
        if ((long) this.cityDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.cityDao.findAll(), "Success: Şehirler listelendi!");
        }
        return new WarningDataResult<>(this.cityDao.findAll(), "Warning: Şehir bulunamadı!");

}
}