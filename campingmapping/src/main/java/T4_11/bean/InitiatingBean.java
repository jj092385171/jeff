package T4_11.bean;

import java.util.Date;

public class InitiatingBean {
	
	private int initiatingnum;
	private int postmember;
	private Date postdate;
	private Date startdate;
	private Date enddate;
	private int currentnum;
	private int acceptablenum;
	private String camparea;
	private int pair;
	
	public InitiatingBean() {
		
	}
	public int getInitiatingnum() {
		return initiatingnum;
	}

	public void setInitiatingnum(int initiatingnum) {
		this.initiatingnum = initiatingnum;
	}

	public int getPostmember() {
		return postmember;
	}

	public void setPostmember(int postmember) {
		this.postmember = postmember;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getCurrentnum() {
		return currentnum;
	}

	public void setCurrentnum(int currentnum) {
		this.currentnum = currentnum;
	}

	public int getAcceptablenum() {
		return acceptablenum;
	}

	public void setAcceptablenum(int acceptablenum) {
		this.acceptablenum = acceptablenum;
	}

	public String getCamparea() {
		return camparea;
	}

	public void setCamparea(String camparea) {
		this.camparea = camparea;
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair) {
		this.pair = pair;
	}
	@Override
	public String toString() {
		return "InitiatingBean [initiatingnum=" + initiatingnum + ", postmember=" + postmember + ", postdate="
				+ postdate + ", startdate=" + startdate + ", enddate=" + enddate + ", currentnum=" + currentnum
				+ ", acceptablenum=" + acceptablenum + ", camparea=" + camparea + ", pair=" + pair + "]";
	}

}

