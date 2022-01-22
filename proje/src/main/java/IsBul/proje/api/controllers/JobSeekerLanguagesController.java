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
import IsBul.proje.business.concretes.JobSeekerLanguageManager;
import IsBul.proje.entities.concretes.jobSeekerLanguage;
import IsBul.proje.entities.dtos.addDtos.jobSeekerLanguageDto;

@RestController
@RequestMapping("/api/jobseekerLanguages")
@CrossOrigin
public class JobSeekerLanguagesController {
    private final JobSeekerLanguageManager jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageManager jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @GetMapping("/getJobseekerLanguagesByCvId")
    public DataResult<List<jobSeekerLanguage>> getJobseekerLanguagesByCvId(@RequestParam int cvId) {
        return this.jobSeekerLanguageService.getJobSeekerLanguageByCurriculaVitaeId(cvId);
    }

    @PostMapping("/addJobseekerLanguages")
    public Result addJobseekerLanguage(@RequestBody jobSeekerLanguageDto jobSeekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }

    @DeleteMapping("/deleteJobSeekerLanguageById")
    public Result deleteJobSeekerLanguageById(@RequestParam int id) {
        return this.jobSeekerLanguageService.deleteJobSeekerLanguageById(id);
    }
}
