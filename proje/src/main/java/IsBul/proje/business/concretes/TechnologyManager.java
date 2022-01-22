package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.TechnologyService;
import IsBul.proje.dataAccess.abstracts.TechnologyDao;
import IsBul.proje.entities.concretes.Technology;
import IsBul.proje.entities.dtos.addDtos.TechnologyDto;
import IsBul.proje.entities.dtos.updateDtos.TechnologyUpdateDto;

@Service
public class TechnologyManager implements TechnologyService {
	   private final TechnologyDao technologieDao;

	    private final DtoConverterService dtoConverterService;

	    @Autowired
	    public TechnologyManager(TechnologyDao technologieDao, DtoConverterService dtoConverterService) {
	        this.technologieDao = technologieDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	    
	@Override
	public Result addTechnology(TechnologyDto pl) {
	     this.technologieDao.save((Technology) this.dtoConverterService.dtoClassConverter(pl, Technology.class));
	        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
	    }

	@Override
	public Result updateTechnology(TechnologyUpdateDto pl) {
		   this.technologieDao.save((Technology) this.dtoConverterService.dtoClassConverter(pl, Technology.class));
	        return new SuccessResult("Success: Programlama dili başarıyla güncellendi!");
	    }

	@Override
	public Result deleteTechnologyById(int id) {
		   this.technologieDao.deleteTechnologieByCVitaeId(id);
	        return new SuccessResult("Success: Teknoloji bilgisi silindi!");
	    }
	@Override
	public DataResult<List<Technology>> getTechnologies() {
	     if (this.technologieDao.findAll().isEmpty()) {
	            return new WarningDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
	        }
	        return new SuccessDataResult<>(
	                this.technologieDao.findAll(),
	                "Success: Programlama dilleri başarıyla listelendi!");
	    }


	@Override
	public DataResult<List<Technology>> getTechnologieByCVitaeId(int id) {
	    if (this.technologieDao.getTechnologieByCVitaeId(id).isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek teknoloji bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.technologieDao.getTechnologieByCVitaeId(id),
                    "Success: Teknolojiler listelendi!");
        }
    }
}
