package vo;

public class cityVo {
	private int city_ID;
	private String city;
	private String cityDes;
	countryVo cvo= new countryVo();
	stateVo svo= new stateVo();
	private String cityStatus;
	
	public String getCityStatus() {
		return cityStatus;
	}
	public void setCityStatus(String cityStatus) {
		this.cityStatus = cityStatus;
	}
	public int getCity_ID() {
		return city_ID;
	}
	public void setCity_ID(int city_ID) {
		this.city_ID = city_ID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityDes() {
		return cityDes;
	}
	public void setCityDes(String cityDes) {
		this.cityDes = cityDes;
	}
	public countryVo getCvo() {
		return cvo;
	}
	public void setCvo(countryVo cvo) {
		this.cvo = cvo;
	}
	public stateVo getSvo() {
		return svo;
	}
	public void setSvo(stateVo svo) {
		this.svo = svo;
	}
	
	


}
