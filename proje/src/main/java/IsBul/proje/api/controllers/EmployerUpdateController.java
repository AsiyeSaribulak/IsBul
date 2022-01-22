package IsBul.proje.api.controllers;

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
import IsBul.proje.business.abstracts.EmployerUpdateService;
import IsBul.proje.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employersUpdate")
@CrossOrigin
public class EmployerUpdateController {
	  private final EmployerUpdateService employerUpdateService;

	    @Autowired
	    public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
	        this.employerUpdateService = employerUpdateService;
	    }

	    @GetMapping("/getByEmployerUpdateId")
	    public DataResult<EmployerUpdate> getEmployerById(int employerId) {
	        return this.employerUpdateService.getEmployerUpdateById(employerId);
	    }

	    @DeleteMapping("/deleteEmployerUpdateById")
	    public Result deleteEmployerById(@RequestParam int employerId) {
	        return this.employerUpdateService.deleteEmployerUpdateById(employerId);
	    }

	    @PostMapping("/addEmployerUpdate")
	    public Result addEmployerUpdate(@RequestBody EmployerUpdate employerUpdate) {
	        return this.employerUpdateService.addEmployerUpdate(employerUpdate);
	    }
}
