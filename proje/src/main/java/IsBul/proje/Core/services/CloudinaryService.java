package IsBul.proje.Core.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import IsBul.proje.Core.utilities.DataResult;

public interface CloudinaryService {
	   DataResult<Map> addPicture(MultipartFile file) throws IOException;
}
