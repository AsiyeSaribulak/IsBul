package IsBul.proje.MernisValidator;

import org.springframework.stereotype.Service;
import IsBul.proje.entities.concretes.jobSeekers;

@Service
public class MernisValidatorManager {
	  public boolean isMernis(jobSeekers jobSeeker) {
	    return jobSeeker.getIdentityNumber().length() == 11;
	  }
}
