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
import IsBul.proje.business.abstracts.DepartmantService;
import IsBul.proje.entities.concretes.Departmants;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmantController {
	private final DepartmantService departmantService;

    @Autowired
    public DepartmantController(DepartmantService departmantService) {
        this.departmantService = departmantService;
    }

    @GetMapping("/getDepartments")
    public DataResult<List<Departmants>> getDepartments() {
        return this.departmantService.getAllDepartmant();
    }

    @PostMapping("/addDepartment")
    public Result addDepartment(@RequestBody Departmants departmant) {
        return this.departmantService.addDepartment(departmant);
    }
}
