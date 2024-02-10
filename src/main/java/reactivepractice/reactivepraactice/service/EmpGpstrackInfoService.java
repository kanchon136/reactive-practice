package reactivepractice.reactivepraactice.service;

import java.time.LocalTime;
import java.util.Optional;

import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EmpGpstrackInfoService {
	Flux<EmpGpstrackInfo> findAllEmpGpstrackInfos();
	Mono<EmpGpstrackInfo> findEmpGpstrackInfoByMkgProfNo(String mkgProfNo);
	Flux<EmpGpstrackInfo> findEmpGpstrackInfosByEmpNo(String empno);
	Mono<Optional<EmpGpstrackInfo>> findLastEmpGpstrackInfoByEmpno(String empno);
	Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByGpsDataDate(String datadate);
	Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByGpsdataDateAndEmpNo(String date, String emono);
	Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByDesigNoAndGpsdatadate(String desigNo,String datadate);
	Flux<EmpGpstrackInfo> findAllEmpGpstrackinfosByDesignation(String desigNo);
	Flux<EmpGpstrackInfo> findAllTrackInfosByBetweenTime(LocalTime starttime ,LocalTime endtime);
}
