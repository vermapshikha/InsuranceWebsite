package vo;

public class complainVo {
	private int complainID;
	private String complainName;
	private String complainEmail;
	private String complainSubject;
	private String complainDes;
	private String complainreplyDescription;
	private String complainDate;
	private String complainTime;
	private loginVo complainFrom;
	private loginVo complainTo;
	private String complainStatus;
	
	public int getComplainID() {
		return complainID;
	}
	public void setComplainID(int complainID) {
		this.complainID = complainID;
	}
	
	
	public String getComplainName() {
		return complainName;
	}
	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}
	public String getComplainEmail() {
		return complainEmail;
	}
	public void setComplainEmail(String complainEmail) {
		this.complainEmail = complainEmail;
	}
	public String getComplainSubject() {
		return complainSubject;
	}
	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}
	public String getComplainDes() {
		return complainDes;
	}
	public void setComplainDes(String complainDes) {
		this.complainDes = complainDes;
	}
	public String getComplainreplyDescription() {
		return complainreplyDescription;
	}
	public void setComplainreplyDescription(String complainreplyDescription) {
		this.complainreplyDescription = complainreplyDescription;
	}
	public loginVo getComplainFrom() {
		return complainFrom;
	}
	public void setComplainFrom(loginVo complainFrom) {
		this.complainFrom = complainFrom;
	}
	public loginVo getComplainTo() {
		return complainTo;
	}
	public void setComplainTo(loginVo complainTo) {
		this.complainTo = complainTo;
	}
	public String getComplainStatus() {
		return complainStatus;
	}
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	public String getComplainDate() {
		return complainDate;
	}
	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}
	public String getComplainTime() {
		return complainTime;
	}
	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}
	
}
