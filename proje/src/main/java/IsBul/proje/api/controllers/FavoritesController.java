package IsBul.proje.api.controllers;

import java.util.List;

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
import IsBul.proje.business.abstracts.FavoriteService;
import IsBul.proje.entities.concretes.Favorite;
import IsBul.proje.entities.dtos.addDtos.FavoriteDto;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {
	   private final FavoriteService favoriteService;

	    public FavoritesController(FavoriteService favoriteService) {
	        this.favoriteService = favoriteService;
	    }

	    @GetMapping("/getFavorites")
	    public DataResult<List<Favorite>> getFavorites() {
	        return this.favoriteService.getFavorites();
	    }

	    @GetMapping("/getFavoritesByJobSeekerId")
	    public DataResult<List<Favorite>> getFavoritesByJobSeekerId(@RequestParam int jobSeekerId) {
	        return this.favoriteService.getFavoriteById(jobSeekerId);
	    }

	    @PostMapping("/addFavorite")
	    public Result addFavorite(@RequestBody FavoriteDto favorite) {
	        return this.favoriteService.addFavorite(favorite);
	    }

	    @DeleteMapping("/deleteFavorite")
	    public Result deleteFavorite(@RequestParam int id) {
	        return this.favoriteService.deleteFavorite(id);
	    }

	    @DeleteMapping("/deleteFavoriteByJobSeekerIdAndJobAdvertId")
	    public Result deleteFavoriteByJobSeekerIdAndJobAdvertId(@RequestParam int jobSeekerId, int jobAdvertId) {
	        return this.favoriteService.deleteFavoriteByjobSeekerIdAndjobAdvertId(jobSeekerId, jobAdvertId);
	    }

}
