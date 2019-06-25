package vo;

import vo.companyVo;
import vo.planVo;

public class portfolioVo {

	private int pp_ID;
	companyVo cvo=new companyVo();
	planVo pvo=new planVo();
	private String policyNumber;
	
	public int getPp_ID() {
		return pp_ID;
	}
	public void setPp_ID(int pp_ID) {
		this.pp_ID = pp_ID;
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
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	
	
}
