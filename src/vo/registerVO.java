package vo;

public class registerVO {
	private int Register_id;
	private String Firstname;
	private String Lastname;
	loginVo l=new loginVo();
	public int getRegister_id() {
		return Register_id;
	}
	public void setRegister_id(int register_id) {
		Register_id = register_id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public loginVo getL() {
		return l;
	}
	public void setL(loginVo l) {
		this.l = l;
	}
	

}
