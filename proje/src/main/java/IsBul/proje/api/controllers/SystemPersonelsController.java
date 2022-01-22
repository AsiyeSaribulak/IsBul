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
import IsBul.proje.business.abstracts.EmployerService;
import IsBul.proje.business.abstracts.SystemPersonService;
import IsBul.proje.business.abstracts.jobAdversimentservice;
import IsBul.proje.entities.concretes.Employers;
import IsBul.proje.entities.concretes.system_personels;

@RestController
@RequestMapping("/api/systemPersonels")
@CrossOrigin
public class SystemPersonelsController {

    private final SystemPersonService systemPersonelService;

    private final jobAdversimentservice jobAdvertService;

    private final EmployerService employerService;

    @Autowired
    public SystemPersonelsController(
            SystemPersonService systemPersonelService,
            jobAdversimentservice jobAdvertService,
            EmployerService employerService) {
        this.systemPersonelService = systemPersonelService;
        this.jobAdvertService = jobAdvertService;
        this.employerService = employerService;
    }

    @GetMapping("/getSystemPersonels")
    public DataResult<List<system_personels>> getSystemPersonels() {
        return this.systemPersonelService.getSystemPersonels();
    }

    @GetMapping("/getSystemPersonelById")
    public DataResult<system_personels> getSystemPersonelById(int systemPersonelId) {
        return this.systemPersonelService.getsystem_personelsById(systemPersonelId);
    }

    @GetMapping("/getEmployerByUpdatedTrue")
    public DataResult<List<Employers>> getEmployerByUpdatedTrue() {
        return this.employerService.getEmployersByUpdatedTrue();
    }

    @DeleteMapping("/deleteSystemPersonelById")
    public Result deleteSystemPersonelById(@RequestParam int systemPersonelId) {
        return this.systemPersonelService.deletesystem_personelsById(systemPersonelId);
    }

    @PostMapping("/addSystemPersonel")
    public Result addSystemPersonel(@RequestBody system_personels systemPersonel) {
        return this.systemPersonelService.addSystemPersonel(systemPersonel);
    }

    @PutMapping("/updateSystemPersonel")
    public Result updateSystemPersonel(@RequestBody system_personels systemPersonel) {
        return this.systemPersonelService.updateSystemPersonel(systemPersonel);
    }

    @PostMapping("/changeIsConfirmed")
    public Result changeIsConfirmed(@RequestParam boolean confirm, int jobAdvertId) {
        return this.jobAdvertService.changeIsConfirmed(confirm, jobAdvertId);
    }

}
