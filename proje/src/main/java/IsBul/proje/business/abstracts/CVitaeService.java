package IsBul.proje.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.entities.concretes.CVitae;
import IsBul.proje.entities.dtos.addDtos.CVitaeDto;
import IsBul.proje.entities.dtos.updateDtos.CVitaeUpdateDto;

public interface CVitaeService {

    Result addCv(CVitaeDto CVitae);

    Result updateCv(CVitaeUpdateDto cVitae);



    DataResult<CVitae> findByJobSeekerId(int jobseekerId);

   
   Result uploadPicture(int cvId, MultipartFile file) throws IOException;

}