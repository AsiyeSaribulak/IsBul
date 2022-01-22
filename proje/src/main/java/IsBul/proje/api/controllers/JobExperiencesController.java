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

import IsBul.proje.business.abstracts.jobExperienceService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobExperience;
import IsBul.proje.entities.dtos.addDtos.jobExperienceDto;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {

    private final jobExperienceService jobExperiencesService;

    @Autowired
    public JobExperiencesController(jobExperienceService jobExperiencesService) {
        this.jobExperiencesService = jobExperiencesService;
    }

    @GetMapping("/getJobExperienceByCvId")
    public DataResult<List<jobExperience>> getjobExperienceByCVitaeId(@RequestParam int cvId) {
        return this.jobExperiencesService.getjobExperienceByCvId(cvId);
    }

    @PostMapping("/addJobExperience")
    public Result addJobExperience(@RequestBody jobExperienceDto jobExperience) {
        return this.jobExperiencesService.addJobExperience(jobExperience);
    }

    @DeleteMapping("/deleteJobExperienceById")
    public Result deleteJobExperienceById(@RequestParam int id) {
        return this.jobExperiencesService.deleteJobExperienceById(id);
    }
}
