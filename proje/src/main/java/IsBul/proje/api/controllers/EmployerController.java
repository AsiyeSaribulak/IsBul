package IsBul.proje.api.controllers;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.EmployerService;
import IsBul.proje.business.abstracts.jobAdversimentservice;
import IsBul.proje.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
    private final EmployerService employerService;
    private final jobAdversimentservice jobAdversimentsService;


    @Autowired
    public EmployerController(EmployerService employerService, jobAdversimentservice jobAdversimentsService) {
        this.employerService = employerService;
        this.jobAdversimentsService = jobAdversimentsService;
    }

    @GetMapping("/getEmployers")
    public DataResult<List<Employers>> getEmployers() {
        return this.employerService.getEmployers();
    }

    @GetMapping("/getByEmployerId")
    public DataResult<Employers> getEmployerById(int employerId) {
        return this.employerService.getEmployerById(employerId);
    }

    @DeleteMapping("/deleteEmployerById")
    public Result deleteEmployerById(@RequestParam int employerId) {
        return this.employerService.deleteEmployerById(employerId);
    }

    @PostMapping("/addEmployer")
    public Result addEmployer(@RequestBody Employers employer) {
        return this.employerService.addEmployer(employer);
    }

    @PutMapping("/updateEmployer")
    public Result updateEmployer(@RequestBody Employers employer) {
        return this.employerService.updateEmployer(employer);
    }


    @PostMapping("/changeIsActive")
    public Result changeIsActive(@RequestParam boolean active, int jobAdversimentId) {
        return this.jobAdversimentsService.changeIsActive(active, jobAdversimentId);
    }

    @PostMapping("/changeIsUpdated")
    public Result changeIsUpdated(@RequestParam boolean update, int employerId) {
        return this.employerService.changeIsUpdated(update, employerId);
    }

    @PostMapping("/addPicture")
    public Result addPicture(int employerId, MultipartFile file) throws IOException {
        return this.employerService.uploadPicture(employerId, file);
    }
}