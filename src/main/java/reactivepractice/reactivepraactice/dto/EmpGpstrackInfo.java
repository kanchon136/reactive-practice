package reactivepractice.reactivepraactice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpGpstrackInfo {
	private String gpsDataId;
	private String mkgProfNo;
	private String employeNo;
	private String employeName;
	private Date gpsDataDate;
	private String gpsDataTime;
	private Float mLatitute;
	private Float mLongitute;
	private int gpsDataFlag;
	private String saUsersId;
	private Date gpsDataDateTime;
	private String gpslocalName;
	private String bateryPct;
	private String intCxnType;
	private String pwrsvMode;
	private String locsharType;
	private String toolTipTxt;
	private String profPhoto;

}
