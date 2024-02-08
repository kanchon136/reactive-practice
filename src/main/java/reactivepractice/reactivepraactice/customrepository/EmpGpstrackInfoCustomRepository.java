package reactivepractice.reactivepraactice.customrepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import reactivepractice.reactivepraactice.dto.EmpGpstrackInfo;
import reactor.core.publisher.Flux;
@Repository
@Transactional
public class EmpGpstrackInfoCustomRepository {
	
	 @Autowired
	 private DatabaseClient databaseClient;

	
	 public Flux<EmpGpstrackInfo> findAllEmpgpsTrackInfos() {
	        String query = "SELECT GPSDATA_ID, MKGPROF_NO, EMPLOYE_NO, EMPLOYE_NM, GPSDATA_DT, GPSDATA_TM, " +
	                " M_LATITUDE, M_LONGITDE, GPSDATA_FG, SAUSERS_ID, GPSDTA_DTM, GPSLOCA_NM, BATERY_PCT, " +
	                " INTCXN_TYP, PWRSV_MODE, LOCSHAR_TYP, TOOLTIPTXT, PROF_PHOTO FROM HRV_GPSDATA";

	       

	        return databaseClient.sql(query)
	                .map((row, rowMetadata) -> new EmpGpstrackInfo(
	                        row.get("GPSDATA_ID", String.class),
	                        row.get("MKGPROF_NO", String.class),
	                        row.get("EMPLOYE_NO", String.class),
	                        row.get("EMPLOYE_NM", String.class),
	                        row.get("GPSDATA_DT", Date.class),
	                        row.get("GPSDATA_TM", String.class),
	                        row.get("M_LATITUDE", Float.class),
	                        row.get("M_LONGITDE", Float.class),
	                        row.get("GPSDATA_FG", Integer.class),
	                        row.get("SAUSERS_ID", String.class),
	                        row.get("GPSDTA_DTM", Date.class),
	                        row.get("GPSLOCA_NM", String.class),
	                        row.get("BATERY_PCT", String.class),
	                        row.get("INTCXN_TYP", String.class),
	                        row.get("PWRSV_MODE", String.class),
	                        row.get("LOCSHAR_TYP", String.class),
	                        row.get("TOOLTIPTXT", String.class),
	                        row.get("PROF_PHOTO", String.class)))
	                .all();
	    }

}
