package IsBul.proje.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.TechnologyService;
import IsBul.proje.entities.concretes.Technology;
import IsBul.proje.entities.dtos.addDtos.TechnologyDto;
import IsBul.proje.entities.dtos.updateDtos.TechnologyUpdateDto;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologiesController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologieService) {
        this.technologyService = technologieService;
    }

    @GetMapping("/getTechnologies")
    public DataResult<List<Technology>> getTechnology() {
        return this.technologyService.getTechnologies();
    }

    @GetMapping("/getJobseekerLanguagesByCvId")
    public DataResult<List<Technology>> getTechnologieByCurriculaVitaeId(@RequestParam int cvId) {
        return this.technologyService.getTechnologieByCVitaeId(cvId);
    }

    @PostMapping("/addTechnology")
    public Result addTechnology(@RequestBody TechnologyDto pl) {
        return this.technologyService.addTechnology(pl);
    }

    @PutMapping("/updateTechnology")
    public Result updateTechnology(@RequestBody TechnologyUpdateDto pl) {
        return this.technologyService.updateTechnology(pl);
    }

    @DeleteMapping("/deleteTechnologyById")
    public Result deleteTechnologyById(@RequestParam int id) {
        return this.technologyService.deleteTechnologyById(id);
    }
}