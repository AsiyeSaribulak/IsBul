package IsBul.proje.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.EducationService;
import IsBul.proje.entities.concretes.Educations;
import IsBul.proje.entities.dtos.addDtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {
	 private final EducationService educationService;

	    @Autowired
	    public EducationController(EducationService educationService) {
	        this.educationService = educationService;
	    }

	    @GetMapping("/getEducations")
	    public DataResult<List<Educations>> getEducations() {
	        return this.educationService.getAllEducations();
	    }

	    @GetMapping("/getEducationsByCvId")
	    public DataResult<List<Educations>> getEducationsByCvId(@RequestParam int cvId) {
	        return this.educationService.getEducationsByCvId(cvId);
	    }

	    @PostMapping("/addEducation")
	    public Result addEducation(@RequestBody EducationDto education) {
	        return this.educationService.addEducation(education);
	    }

	    @DeleteMapping("/deleteEducationById")
	    public Result deleteEducationById(@RequestParam int id) {
	        return this.educationService.deleteEducationById(id);
	    }
}
