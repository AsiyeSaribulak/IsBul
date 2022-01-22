package IsBul.proje.Core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import IsBul.proje.Core.services.CloudinaryService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.İmageUploader.CloudinaryManager;

@Service
public class CloudinaryUploaderManagerAdapter implements CloudinaryService {
	  private final CloudinaryManager cloudinaryManager;

	    @Autowired
	    public CloudinaryUploaderManagerAdapter(CloudinaryManager cloudinaryManager) {
	        this.cloudinaryManager = cloudinaryManager;
	    }
	@Override
	public DataResult<Map> addPicture(MultipartFile file) throws IOException {
		   return this.cloudinaryManager.addPicture(file);
    }

}
