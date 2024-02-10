package reactivepractice.reactivepraactice.serviceImpl;

 
import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactivepractice.reactivepraactice.customrepository.EmpGpstrackInfoCustomRepository;
import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactivepractice.reactivepraactice.service.EmpGpstrackInfoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

	@Override
	public Mono<EmpGpstrackInfo> findEmpGpstrackInfoByMkgProfNo(String mkgProfNo) {
		 
		return empCuStomRepo.findAllEmpgpsTrackInfos()
				.filter(f-> f.getMkgProfNo() != null && f.getMkgProfNo().equalsIgnoreCase(mkgProfNo))
				.next();//.defaultIfEmpty(null);
	}

	@Override
	public Flux<EmpGpstrackInfo> findEmpGpstrackInfosByEmpNo(String empno) {
		 
		return empCuStomRepo.findAllEmpgpsTrackInfos()
				.filter(f-> f.getMkgProfNo() != null && f.getMkgProfNo().equalsIgnoreCase(empno))
				.sort(Comparator.comparing(EmpGpstrackInfo::getGpsDataTime,Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
				.delayElements(Duration.ofMillis(1000));
	}

	@Override
	public Mono<Optional<EmpGpstrackInfo>> findLastEmpGpstrackInfoByEmpno(String empno) {
		 
		return empCuStomRepo.findAllEmpgpsTrackInfos().filter(
				f-> f.getMkgProfNo().equalsIgnoreCase(empno))
				.reduce((data1,data2)-> data1.getGpsDataTime().compareTo(data2.getGpsDataTime())>= 0? data1:data2 )
				.map(Optional::ofNullable);
	}

	@Override
	public Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByGpsDataDate(String datadate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByGpsdataDateAndEmpNo(String date, String emono) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<EmpGpstrackInfo> findAllEmpGpstrackInfosByDesigNoAndGpsdatadate(String desigNo, String datadate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<EmpGpstrackInfo> findAllEmpGpstrackinfosByDesignation(String desigNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<EmpGpstrackInfo> findAllTrackInfosByBetweenTime(LocalTime starttime, LocalTime endtime) {
		 
		return null;
	}

	 

}
