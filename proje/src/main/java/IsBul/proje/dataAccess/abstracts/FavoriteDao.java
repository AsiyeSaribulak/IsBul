package IsBul.proje.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer>{

	List<Favorite> getFavoriteByjobSeekerId(int id);
	
	@Transactional
	void deleteFavoriteByjobSeekerIdAndJobAdversimentsId(int jobSeekerId, int JobAdversimentId);
}
