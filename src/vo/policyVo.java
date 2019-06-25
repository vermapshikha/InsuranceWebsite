package vo;

public class policyVo {
	private int policy_Id;
    private String policyCompany;
	private String policyName;
	private String policyNumber;
	private String policyAmount;
	private String policyType;
	private String policyPlan;
	private String policyTerm;



	public int getPolicy_Id() {
		return policy_Id;
	}
	
	public void setPolicy_Id(int policy_Id) {
		this.policy_Id = policy_Id;
	}
	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(String policyAmount) {
		this.policyAmount = policyAmount;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyCompany() {
		return policyCompany;
	}

	public void setPolicyCompany(String policyCompany) {
		this.policyCompany = policyCompany;
	}

	public String getPolicyPlan() {
		return policyPlan;
	}

	public void setPolicyPlan(String policyPlan) {
		this.policyPlan = policyPlan;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

}
