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
import IsBul.proje.business.abstracts.jobAdversimentservice;
import IsBul.proje.entities.concretes.jobAdversiments;
import IsBul.proje.entities.dtos.addDtos.jobAdversimentDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdversimentController {
    private final jobAdversimentservice jobAdversimentsService;

    @Autowired
    public JobAdversimentController(jobAdversimentservice jobAdversimentsService) {
        this.jobAdversimentsService = jobAdversimentsService;
    }

    @GetMapping("/getJobAdverts")
    public DataResult<List<jobAdversiments>> getJobAdverts() {
        return this.jobAdversimentsService.getjobAdversiments();
    }

    @GetMapping("/getSortedJobAdverts")
    public DataResult<List<jobAdversiments>> getSortedJobAdverts() {
        return this.jobAdversimentsService.getSortedJjobAdversiments();
    }

    @GetMapping("/getActiveJobAdverts")
    public DataResult<List<jobAdversiments>> getActiveJobAdverts() {
        return this.jobAdversimentsService.getActivejobAdversiments();
    }

    @GetMapping("/getJobAdvertByCompanyName")
    public DataResult<List<jobAdversiments>> getJobAdvertByCompanyName(String companyName) {
        return this.jobAdversimentsService.getjobAdversimentByCompanyName(companyName);
    }

    @GetMapping("/getJobAdvertByEmployerId")
    public DataResult<List<jobAdversiments>> getJobAdvertByEmployerId(int employerId) {
        return this.jobAdversimentsService.getjobAdversimentByEmployerId(employerId);
    }

    @GetMapping("/getActiveJobAdvertsSorted")
    public DataResult<List<jobAdversiments>> findAllByIsActiveTrueSorted(@RequestParam boolean isDesc) {
        return this.jobAdversimentsService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrue")
    public DataResult<List<jobAdversiments>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        return this.jobAdversimentsService.getjobAdversimentByIsActiveTrueAndIsConfirmedTrue();
    }

    @GetMapping("/getActiveAndConfirmedJobAdvertCount")
    public int getActiveAndConfirmedJobAdvertCount() {
        if (Math.round((double) this.jobAdversimentsService.getjobAdversimentByIsActiveTrueAndIsConfirmedTrue()
                .getData()
                .size() / 5) < 1) {
            return 1;
        } else {
            return (int) Math.ceil((double) this.jobAdversimentsService.getjobAdversimentByIsActiveTrueAndIsConfirmedTrue()
            	.getData()
            	.size() / (double) 5);
        }
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc")
    public DataResult<List<jobAdversiments>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(
            @RequestParam int pageNo,
            int pageSize) {
        return this.jobAdversimentsService.getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageDesc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc")
    public DataResult<List<jobAdversiments>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(
            @RequestParam int pageNo,
            int pageSize) {
        return this.jobAdversimentsService.getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageAsc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<jobAdversiments> getJobAdvertById(int jobAdvertId) {
        return this.jobAdversimentsService.getjobAdversimentById(jobAdvertId);
    }

    @DeleteMapping("/deleteJobAdvertById")
    public Result deleteJobAdvertById(@RequestParam int jobAdvertId) {
        return this.jobAdversimentsService.deleteJobAdvertById(jobAdvertId);
    }

    @PostMapping("/addJobadvert")
    public Result addJobAdverts(@RequestBody jobAdversimentDto jobAdvert) {
        return this.jobAdversimentsService.addJobAdvert(jobAdvert);
    }

}
