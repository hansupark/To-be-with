package vo;

public class ReportVo {

	private int reportNum;
	private int reporterNum;
	private int reportedUserNum;
	
	private String title;
	private String content;
	
	private short type;
	private int objectNum;
	
	private boolean isApproved;

	public int getReportNum() {
		return reportNum;
	}

	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}

	public int getReporterNum() {
		return reporterNum;
	}

	public void setReporterNum(int reporterNum) {
		this.reporterNum = reporterNum;
	}

	public int getReportedUserNum() {
		return reportedUserNum;
	}

	public void setReportedUserNum(int reportedUserNum) {
		this.reportedUserNum = reportedUserNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getObjectNum() {
		return objectNum;
	}

	public void setObjectNum(int objectNum) {
		this.objectNum = objectNum;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "ReportVo [reportNum=" + reportNum + ", reporterNum=" + reporterNum + ", reportedUserNum="
				+ reportedUserNum + ", title=" + title + ", content=" + content + ", type=" + type + ", objectNum="
				+ objectNum + ", isApproved=" + isApproved + "]";
	}
	
}
