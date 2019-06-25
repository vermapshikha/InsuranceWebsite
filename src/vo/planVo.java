package vo;

public class planVo {
	companyVo cvo= new companyVo();
	private int plan_id;
	private String planName;
	private String planDes;
	private String PlanStatus;
	
	
	public String getPlanStatus() {
		return PlanStatus;
	}
	public void setPlanStatus(String planStatus) {
		PlanStatus = planStatus;
	}
	public companyVo getCvo() {
		return cvo;
	}
	public void setCvo(companyVo cvo) {
		this.cvo = cvo;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanDes() {
		return planDes;
	}
	public void setPlanDes(String planDes) {
		this.planDes = planDes;
	}

}
