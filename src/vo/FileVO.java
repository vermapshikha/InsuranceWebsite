package vo;

public class FileVO {

	private int fileid;

	private String filename;
	private String filepath;
	private companyVo cvo;
	private agentVo avo;

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public companyVo getCvo() {
		return cvo;
	}

	public void setCvo(companyVo cvo) {
		this.cvo = cvo;
	}

	public agentVo getAvo() {
		return avo;
	}

	public void setAvo(agentVo avo) {
		this.avo = avo;
	}

}
