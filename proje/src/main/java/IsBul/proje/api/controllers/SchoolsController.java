package IsBul.proje.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.SchoolService;
import IsBul.proje.entities.concretes.Schools;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getSchools")
    public DataResult<List<Schools>> getSchools() {
        return this.schoolService.getAllSchool();
    }

    @PostMapping("/addSchool")
    public Result addJobSeeker(@RequestBody Schools school) {
        return this.schoolService.addSchool(school);
    }
}