package IsBul.proje.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.utilities.DataResult;
import IsBul.proje.Core.utilities.ErrorResult;
import IsBul.proje.Core.utilities.Result;
import IsBul.proje.Core.utilities.SuccessDataResult;
import IsBul.proje.Core.utilities.SuccessResult;
import IsBul.proje.Core.utilities.WarningDataResult;
import IsBul.proje.business.abstracts.jobPositionService;
import IsBul.proje.dataAccess.abstracts.jobPositionDao;
import IsBul.proje.entities.concretes.jobPosition;

@Service
public class JobPositionManager implements jobPositionService {
	private final jobPositionDao jobPositionsDao;

    @Autowired
    public JobPositionManager(jobPositionDao jobPositionsDao) {
        this.jobPositionsDao = jobPositionsDao;
    }
	@Override
	public DataResult<List<jobPosition>> getPositions() {
		   if ((long) this.jobPositionsDao.findAll().size() > 0) {
	            return new SuccessDataResult<>(this.jobPositionsDao.findAll(), "Success: Pozisyonalar listelendi!");
	        }
	        return new WarningDataResult<>(this.jobPositionsDao.findAll(), "Warning: Herhangi bir pozisyon bulunamadı!");
	    }

	@Override
	public Result addJobPosition(jobPosition jobPositions) {
	     try {
	            this.jobPositionsDao.save(jobPositions);
	            return new SuccessResult("Success: Pozisyon sisteme eklendi!");
	        } catch (Exception e) {
	            return new ErrorResult("Error: Sisteme kayıtlı böyle bir pozisyon mevcut!");
	        }
	    }

}
