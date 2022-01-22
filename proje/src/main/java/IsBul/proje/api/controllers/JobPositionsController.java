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
import IsBul.proje.business.abstracts.jobPositionService;
import IsBul.proje.entities.concretes.jobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

    private final jobPositionService jobPositionsService;

    @Autowired
    public JobPositionsController(jobPositionService jobPositionsService) {
        this.jobPositionsService = jobPositionsService;
    }

    @GetMapping("/getpositions")
    public DataResult<List<jobPosition>> getPositions() {
        return this.jobPositionsService.getPositions();
    }

    @PostMapping("/addposition")
    public Result addJobPosition(@RequestBody jobPosition jobPosition) {
        return this.jobPositionsService.addJobPosition(jobPosition);
    }
}
