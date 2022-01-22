package IsBul.proje.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import IsBul.proje.entities.concretes.system_personels;

public interface SystemPersonelDao extends JpaRepository<system_personels, Integer> {
	system_personels  getsystem_personelById(int id);
	@Transactional
	void deletesystem_personelById(int id);
}
