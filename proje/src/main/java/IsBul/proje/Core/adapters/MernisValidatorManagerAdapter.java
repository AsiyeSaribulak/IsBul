package IsBul.proje.Core.adapters;

import org.springframework.stereotype.Service;

import IsBul.proje.Core.services.MernisCheckService;
import IsBul.proje.MernisValidator.MernisValidatorManager;
import IsBul.proje.entities.concretes.jobSeekers;

@Service
public class MernisValidatorManagerAdapter implements MernisCheckService {
	  private final MernisValidatorManager mernisValidatorManager;

	    public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorManager) {
	        this.mernisValidatorManager = mernisValidatorManager;
	    }
	@Override
	public boolean isMernis(jobSeekers jobSeeker) {
		   return this.mernisValidatorManager.isMernis(jobSeeker);
    }
}
