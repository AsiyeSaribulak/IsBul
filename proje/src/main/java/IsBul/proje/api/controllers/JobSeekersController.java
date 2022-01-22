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
import IsBul.proje.business.abstracts.JobSeekerService;
import IsBul.proje.entities.concretes.jobSeekers;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;
	@Autowired
	// @ Autoyu kaldır yerine bunu yaz => private jobSeekers jobSeeker;
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getJobseekers")
    public DataResult<List<jobSeekers>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }

    @GetMapping("/getJobSeekerById")
    public DataResult<jobSeekers> getJobSeekerById(int jobSeekerId) {
        return this.jobSeekerService.getJobSeekerById(jobSeekerId);
    }

    @DeleteMapping("/deleteJobSeekerById")
    public Result deleteJobSeekerById(@RequestParam int jobSeekerId) {
        return this.jobSeekerService.deleteJobSeekerById(jobSeekerId);
    }

    @PostMapping("/addJobseeker")
    public Result addJobSeeker(@RequestBody jobSeekers jobSeeker) {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }


}
