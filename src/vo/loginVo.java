package vo;

public class loginVo {


	private int login_ID;
	private String userName;
	private String passWord;
	private String User_type;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUser_type() {
		return User_type;
	}
	public void setUser_type(String user_type) {
		User_type = user_type;
	}
	public int getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(int login_ID) {
		this.login_ID = login_ID;
	}
	

}
