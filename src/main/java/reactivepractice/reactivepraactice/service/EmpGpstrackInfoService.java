package reactivepractice.reactivepraactice.service;

import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactor.core.publisher.Flux;


public interface EmpGpstrackInfoService {
	Flux<EmpGpstrackInfo> findAllEmpGpstrackInfos();

}
