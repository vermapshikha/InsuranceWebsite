package vo;

public class policyName {

	private int name_ID;
	companyVo cvo=new companyVo();
	planVo pvo=new planVo();
	private String policyName;
	private String policyDes;
	private String nameStatus;
	
	
	
	public String getNameStatus() {
		return nameStatus;
	}
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	public int getName_ID() {
		return name_ID;
	}
	public void setName_ID(int name_ID) {
		this.name_ID = name_ID;
	}
	public companyVo getCvo() {
		return cvo;
	}
	public void setCvo(companyVo cvo) {
		this.cvo = cvo;
	}
	public planVo getPvo() {
		return pvo;
	}
	public void setPvo(planVo pvo) {
		this.pvo = pvo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyDes() {
		return policyDes;
	}
	public void setPolicyDes(String policyDes) {
		this.policyDes = policyDes;
	}
	
}
