package T4_09._05_jobComment.model;

import java.util.Date;

public class jobCommentBean {
	private int uID;//會員
	private Date jDate;//發言日期
	private String content;//評論內容
	private int reportID;//檢舉編號
	private String reason;//檢舉原因

	public jobCommentBean(){
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public Date getjDate() {
		return jDate;
	}

	public void setjDate(Date jDate) {
		this.jDate = jDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public jobCommentBean(int uID, Date jDate, String content, int reportID, String reason) {
		super();
		this.uID = uID;
		this.jDate = jDate;
		this.content = content;
		this.reportID = reportID;
		this.reason = reason;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("jobCommentBean [uID=");
		builder.append(uID);
		builder.append(", jDate=");
		builder.append(jDate);
		builder.append(", content=");
		builder.append(content);
		builder.append(", reportID=");
		builder.append(reportID);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}

}
