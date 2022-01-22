package IsBul.proje.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.business.abstracts.CityService;
import IsBul.proje.entities.concretes.City;

	@RestController
	@RequestMapping("/api/cities")
	@CrossOrigin
	public class CitiesController {
	    private final CityService cityService;

	    @Autowired
	    public CitiesController(CityService cityService) {
	        this.cityService = cityService;
	    }

	    @GetMapping("/getCities")
	    public DataResult<List<City>> getCities() {
	        return this.cityService.getCities();
	    }
	}
