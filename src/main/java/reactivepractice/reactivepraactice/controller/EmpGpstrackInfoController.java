package reactivepractice.reactivepraactice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactivepractice.reactivepraactice.service.EmpGpstrackInfoService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class EmpGpstrackInfoController {
	
@Autowired	
private EmpGpstrackInfoService empGpstrackInfoService;

@GetMapping(value = "/findAllEmpGpstrackInfos")	//,produces = MediaType.TEXT_EVENT_STREAM_VALUE
public Flux<EmpGpstrackInfo> findAllGpsTrackInfos(){
		return empGpstrackInfoService.findAllEmpGpstrackInfos();
	}

@GetMapping("/")
private String testing() {
	return "testing successfully...";
	
}

}
