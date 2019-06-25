package vo;

public class feedbackVo {
	private int feedback_ID;
	private String userName;
	private String userEmail;
	private String feedbackSubject;
	private String feedbackDes;
	private String feedbackDate;
	private String feedbackTime;
	private loginVo feedbackFrom;
	private String feedbackStatus;
	
	
	public String getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public loginVo getFeedbackFrom() {
		return feedbackFrom;
	}
	public void setFeedbackFrom(loginVo feedbackFrom) {
		this.feedbackFrom = feedbackFrom;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public String getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	
	
	public int getFeedback_ID() {
		return feedback_ID;
	}
	public void setFeedback_ID(int feedback_ID) {
		this.feedback_ID = feedback_ID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFeedbackSubject() {
		return feedbackSubject;
	}
	public void setFeedbackSubject(String feedbackSubject) {
		this.feedbackSubject = feedbackSubject;
	}
	public String getFeedbackDes() {
		return feedbackDes;
	}
	public void setFeedbackDes(String feedbackDes) {
		this.feedbackDes = feedbackDes;
	}
	
}
