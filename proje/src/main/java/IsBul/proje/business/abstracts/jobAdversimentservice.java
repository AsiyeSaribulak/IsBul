package IsBul.proje.business.abstracts;

import java.util.List;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.jobAdversiments;
import IsBul.proje.entities.dtos.addDtos.jobAdversimentDto;

public interface jobAdversimentservice {

    DataResult<List<jobAdversiments>> getjobAdversiments();

    DataResult<List<jobAdversiments>> getSortedJjobAdversiments();

    DataResult<List<jobAdversiments>> getActivejobAdversiments();

    DataResult<List<jobAdversiments>> getjobAdversimentByCompanyName(String companyName);

    DataResult<List<jobAdversiments>> getjobAdversimentByEmployerId(int employerId);

    DataResult<List<jobAdversiments>> findAllByIsActiveTrue(boolean isDesc);

    DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo, int pageSize);

    DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize);

    DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrue();

    DataResult<jobAdversiments> getjobAdversimentById(int jobAdvertId);

    Result changeIsActive(boolean active, int jobAdversimentId);

    Result changeIsConfirmed(boolean confirm, int jobAdversimentId);

    Result addJobAdvert(jobAdversimentDto jobAdversiment);

    Result deleteJobAdvertById(int jobAdversimentId);
}

