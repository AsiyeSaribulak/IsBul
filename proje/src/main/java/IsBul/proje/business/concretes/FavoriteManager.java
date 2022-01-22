package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.FavoriteService;
import IsBul.proje.dataAccess.abstracts.FavoriteDao;
import IsBul.proje.entities.concretes.Favorite;
import IsBul.proje.entities.dtos.addDtos.FavoriteDto;

@Service
public class FavoriteManager implements FavoriteService {
	  private final FavoriteDao favoriteDao;

	    private final DtoConverterService dtoConverterService;

	    @Autowired
	    public FavoriteManager(FavoriteDao favoriteDao, DtoConverterService dtoConverterService) {
	        this.favoriteDao = favoriteDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	
	@Override
	public Result addFavorite(FavoriteDto favorite) {
	     this.favoriteDao.save((Favorite) this.dtoConverterService.dtoClassConverter(favorite, Favorite.class));
	        return new SuccessResult("Success: Favorilere eklendi!");
	    }


	@Override
	public Result deleteFavorite(int id) {
	     this.favoriteDao.deleteById(id);
	        return new SuccessResult("Success: Favori başarıyla kaldırıldı!");
	    }

	@Override
	public Result deleteFavoriteByjobSeekerIdAndjobAdvertId(int jobSeekerId, int jobAdvertId) {
	    this.favoriteDao.deleteFavoriteByjobSeekerIdAndJobAdversimentsId(jobSeekerId, jobAdvertId);
        return new SuccessResult("Success: Favori başarıyla kaldırıldı!");
    }

	@Override
	public DataResult<List<Favorite>> getFavorites() {
	    if (this.favoriteDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.favoriteDao.findAll(), "Success: Favoriler başarıyla listelendi!");
        } else {
            return new WarningDataResult<>(this.favoriteDao.findAll(), "Warning: Kayıtlı Favori listesi bulunamadı!");
        }
    }

	@Override
	public DataResult<List<Favorite>> getFavoriteById(int id) {
	      if (this.favoriteDao.getFavoriteByjobSeekerId(id).size() > 0) {
	            return new SuccessDataResult<>(
	                    this.favoriteDao.getFavoriteByjobSeekerId(id),
	                    "Success: " + id + " id li iş arayana ait favoriler listelendi!");
	        } else {
	            return new WarningDataResult<>(
	                    this.favoriteDao.getFavoriteByjobSeekerId(id),
	                    "Warning: " + id + " id li iş arayana ait favori bulunamadı!");
	        }

	    }
	}
