package IsBul.proje.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.business.abstracts.SocialMediasService;
import IsBul.proje.entities.concretes.SocialMedia;
import IsBul.proje.entities.dtos.addDtos.SocialMediaDto;
import IsBul.proje.entities.dtos.updateDtos.SocialMediaUpdateDto;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {

    private final SocialMediasService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediasService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getSocialMediaByCurriculaVitaeId")
    public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(@RequestParam int cvId) {
        return this.socialMediaService.getSocialMediaByCurriculaVitaeId(cvId);
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMediaDto socialMedia) {
        return this.socialMediaService.addSocialMedia(socialMedia);
    }

    @PutMapping("/updateSocialMedia")
    public Result updateSocialMedia(@RequestBody SocialMediaUpdateDto socialMedia) {
        return this.socialMediaService.updateSocialMedia(socialMedia);
    }
}
