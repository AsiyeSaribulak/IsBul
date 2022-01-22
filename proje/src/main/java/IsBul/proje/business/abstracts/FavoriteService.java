package IsBul.proje.business.abstracts;

import java.util.List;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.Favorite;
import IsBul.proje.entities.dtos.addDtos.FavoriteDto;

public interface FavoriteService {
	  Result addFavorite(FavoriteDto favorite);

	    Result deleteFavorite(int id);

	    Result deleteFavoriteByjobSeekerIdAndjobAdvertId(int jobSeekerId, int jobAdvertId);

	    DataResult<List<Favorite>> getFavorites();

	    DataResult<List<Favorite>> getFavoriteById(int id);
}
