package vo;

public class RegVo {
	
	private int pg_id;
	
	companyVo cvo=new companyVo();
	planVo pvo=new planVo();
	policyName nvo = new policyName(); 
	private String age;
	private String term;
	private String amount;
	
	public int getPg_id() {
		return pg_id;
	}
	public void setPg_id(int pg_id) {
		this.pg_id = pg_id;
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
	public policyName getNvo() {
		return nvo;
	}
	public void setNvo(policyName nvo) {
		this.nvo = nvo;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
		
}

		
	