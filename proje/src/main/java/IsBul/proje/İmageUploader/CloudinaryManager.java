package IsBul.proje.İmageUploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.ErrorDataResult;
import IsBul.proje.Core.utilities.SuccessDataResult;

@Service
public class CloudinaryManager {
	Cloudinary cloudinary;

    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "asiyesrblk",
                "api_key", "465249545568193",
                "api_secret", "PI4TAyEuF1BqJZjAQKzlSOFdrC0"));
    }
	
    public DataResult<Map> addPicture(MultipartFile multipartFile) throws IOException {
        Map<String, Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        return new SuccessDataResult<>(uploader);
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\Casper\\Desktop\\java ec\\proje\\Pictures\\" + multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}




