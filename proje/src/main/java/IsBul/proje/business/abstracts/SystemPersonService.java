package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.system_personels;

public interface SystemPersonService {
	 DataResult<List<system_personels>> getSystemPersonels();
	 Result addSystemPersonel(system_personels systemPersonel);
	 Result updateSystemPersonel(system_personels systemPersonel);
	 DataResult<system_personels> getsystem_personelsById(int systemPersonelId);
	 Result deletesystem_personelsById(int systemPersonelId);
}
