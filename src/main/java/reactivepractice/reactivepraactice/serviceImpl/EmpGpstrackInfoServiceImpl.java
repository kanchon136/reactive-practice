package reactivepractice.reactivepraactice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactivepractice.reactivepraactice.customrepository.EmpGpstrackInfoCustomRepository;
import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactivepractice.reactivepraactice.service.EmpGpstrackInfoService;
import reactor.core.publisher.Flux;

@Service
public class EmpGpstrackInfoServiceImpl implements EmpGpstrackInfoService{
	
    @Autowired
	private EmpGpstrackInfoCustomRepository empCuStomRepo;
    
	@Override
	public Flux<EmpGpstrackInfo> findAllEmpGpstrackInfos() {
		 
		return empCuStomRepo.findAllEmpgpsTrackInfos();
//				.collectList()
//				.doOnNext(infos-> {
//					System.out.println("Element size=:"+infos.size());
//				}).flatMapMany(Flux::fromIterable);
	}

}
