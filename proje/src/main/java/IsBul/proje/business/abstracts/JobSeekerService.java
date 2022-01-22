package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobSeekers;

public interface JobSeekerService {
	 DataResult<List<jobSeekers>> getJobSeekers();
	 Result addJobSeeker(jobSeekers jobSeeker);
	 Result deleteJobSeekerById(int jobSeekerId);
	 DataResult<jobSeekers> getJobSeekerById(int jobSeekerId);
}
