package IsBul.proje.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
