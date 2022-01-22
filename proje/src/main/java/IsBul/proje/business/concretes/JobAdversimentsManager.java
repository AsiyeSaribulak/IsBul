package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.dtoConverter.DtoConverterService;
import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.jobAdversimentservice;
import IsBul.proje.dataAccess.abstracts.jobAdversimentDao;
import IsBul.proje.entities.concretes.jobAdversiments;
import IsBul.proje.entities.dtos.addDtos.jobAdversimentDto;

@Service
public class JobAdversimentsManager implements jobAdversimentservice{
    private final jobAdversimentDao jobAdvertsDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobAdversimentsManager(jobAdversimentDao jobAdvertsDao, DtoConverterService dtoConverterService) {
        this.jobAdvertsDao = jobAdvertsDao;
        this.dtoConverterService = dtoConverterService;
    }

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversiments() {
	    if ((long) this.jobAdvertsDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Success: Tüm iş ilanları listelendi.");
        }
        return new WarningDataResult<>(this.jobAdvertsDao.findAll(), "Maalesef iş  ilanı bulunamadı!");
    }

	@Override
	public DataResult<List<jobAdversiments>> getSortedJjobAdversiments() {
	     Sort sort = Sort.by(Sort.Direction.ASC, "id");
	        return new SuccessDataResult<>(
	                this.jobAdvertsDao.findAll(sort),
	                "Success: iş ilanları listelendi!");
	    }

	@Override
	public DataResult<List<jobAdversiments>> getActivejobAdversiments() {
	      if ((long) this.jobAdvertsDao.findAllByIsActiveTrue().size() > 0) {
	            return new SuccessDataResult<>(
	                    this.jobAdvertsDao.findAllByIsActiveTrue(),
	                    "Success: Aktif tüm iş ilanları listelendi!");
	        }
	        return new WarningDataResult<>(
	                this.jobAdvertsDao.findAllByIsActiveTrue(),
	                "Maalesef aktif iş ilanı bulunamadı!");
	    }

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversimentByCompanyName(String companyName) {
	    Sort sort = Sort.by(Sort.Direction.ASC, "id");
        if ((long) this.jobAdvertsDao.getJobAdvertByEmployer_CompanyName(companyName, sort).size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByEmployer_CompanyName(
                    companyName, sort), "Success: Şirket'e ait tüm ilanlar listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByEmployer_CompanyName(companyName, sort),
                "Şirket'e ait herhangi bir ilan bulunamadı!");

    }

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversimentByEmployerId(int employerId) {
	     Sort sort = Sort.by(Sort.Direction.ASC, "isConfirmed", "id");
	        if ((long) this.jobAdvertsDao.getJobAdvertByEmployerId(employerId, sort).size() > 0) {
	            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByEmployerId(
	                    employerId, sort), "Success: Şirket'e ait tüm ilanlar listelendi!");
	        }
	        return new WarningDataResult<>(
	                this.jobAdvertsDao.getJobAdvertByEmployerId(employerId, sort),
	                "Şirket'e ait herhangi bir ilan bulunamadı!");
	    }
	@Override
	public DataResult<List<jobAdversiments>> findAllByIsActiveTrue(boolean isDesc) {
	    Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "airdate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "airdate");
        }
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                    "Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                "Aktif iş ilanı bulunamadı!");
    }

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo,
			int pageSize) {
        
    Sort sort;
    sort = Sort.by(Sort.Direction.DESC, "airdate");
    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

    if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
        return new SuccessDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre azalarak listelendi!");
    }

    return new WarningDataResult<>(
            this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
            "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
}

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrue() {
	    if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue().size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre artarak listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

	@Override
	public DataResult<jobAdversiments> getjobAdversimentById(int jobAdvertId) {
		   if (this.jobAdvertsDao.getJobAdversimentById(jobAdvertId) == null) {
	            return new WarningDataResult<>("Warning: Kayıtlı İş İlanı bulunamadı!");
	        } else {
	            return new SuccessDataResult<>(
	                    this.jobAdvertsDao.getJobAdversimentById(jobAdvertId),
	                    "Success: İş İlanı listelendi!");
	        }
	    }
	@Override
	public Result changeIsActive(boolean active, int jobAdversimentId) {
	     this.jobAdvertsDao.changeIsActive(active, jobAdversimentId);
	        return new SuccessResult("Success: İlan aktiflik durumu değiştirildi!");
	    }

	@Override
	public Result changeIsConfirmed(boolean confirm, int jobAdversimentId) {
	    this.jobAdvertsDao.changeIsConfirmed(confirm, jobAdversimentId);
        return new SuccessResult("Success: İlan onay durumu değiştirildi!");
    }

	@Override
	public Result addJobAdvert(jobAdversimentDto jobAdversiment) {
	      this.jobAdvertsDao.save((jobAdversiments) this.dtoConverterService.dtoClassConverter(
	                jobAdversiment,
	                jobAdversimentDto.class));
	        return new SuccessResult("Success: İlan sisteme eklendi!");
	    }

	@Override
	public Result deleteJobAdvertById(int jobAdversimentId) {
	     this.jobAdvertsDao.deleteJobAdversimentById(jobAdversimentId);
	        return new SuccessResult("Success: İş ilanı silindi!");
	    }

	@Override
	public DataResult<List<jobAdversiments>> getjobAdversimentByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo,
			int pageSize) {
		
		
	    Sort sort;
        sort = Sort.by(Sort.Direction.ASC, "airdate");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre artarak listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

}
