package vo;

public class stateVo {
	private int state_ID;
	private String state;
	private String stateDes;
	private countryVo cvo;
	private String stateStatus;
	
	public String getStateStatus() {
		return stateStatus;
	}
	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}
	public int getState_ID() {
		return state_ID;
	}
	public void setState_ID(int state_ID) {
		this.state_ID = state_ID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateDes() {
		return stateDes;
	}
	public void setStateDes(String stateDes) {
		this.stateDes = stateDes;
	}
	public countryVo getCvo() {
		return cvo;
	}
	public void setCvo(countryVo cvo) {
		this.cvo = cvo;
	}
	

}
