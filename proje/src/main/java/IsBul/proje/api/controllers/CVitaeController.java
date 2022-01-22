package IsBul.proje.api.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.CVitaeService;
import IsBul.proje.entities.concretes.CVitae;
import IsBul.proje.entities.dtos.addDtos.CVitaeDto;
import IsBul.proje.entities.dtos.updateDtos.CVitaeUpdateDto;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CVitaeController {
	  private final CVitaeService cVitaeService;

	    public CVitaeController(CVitaeService cVitaeService) {
	        this.cVitaeService = cVitaeService;
	    }

	    @GetMapping("/getCvWithJobSeekerId")
	    public DataResult<CVitae> findCvByJobSeekerId(int jobseekerId) {
	        return this.cVitaeService.findByJobSeekerId(jobseekerId);
	    }

	    @PostMapping("/addCv")
	    public Result addCv(@RequestBody CVitaeDto cVitae) {
	        return this.cVitaeService.addCv(cVitae);
	    }

	    @PutMapping("/updateCv")
	    public Result updateCv(@RequestBody CVitaeUpdateDto cVitae) {
	        return this.cVitaeService.updateCv(cVitae);
	    }

	    @PostMapping("/addPicture")
	    public Result addPicture(int cvId, MultipartFile file) throws IOException {
	        return this.cVitaeService.uploadPicture(cvId, file);
	    }
	}