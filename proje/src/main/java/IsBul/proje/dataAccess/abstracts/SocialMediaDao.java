package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
	SocialMedia getSocialMediaByCVitaeId(int id);
}
