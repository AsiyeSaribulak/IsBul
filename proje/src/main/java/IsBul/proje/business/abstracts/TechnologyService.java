package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Technology;
import IsBul.proje.entities.dtos.addDtos.TechnologyDto;
import IsBul.proje.entities.dtos.updateDtos.TechnologyUpdateDto;

public interface TechnologyService {
	    Result addTechnology(TechnologyDto pl);
	    Result updateTechnology(TechnologyUpdateDto pl);
	    Result deleteTechnologyById(int id);
	    DataResult<List<Technology>> getTechnologies();
	    DataResult<List<Technology>> getTechnologieByCVitaeId(int id);
}
