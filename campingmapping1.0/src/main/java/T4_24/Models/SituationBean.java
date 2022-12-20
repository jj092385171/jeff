package T4_24.Models;

public class SituationBean {
	
	private int statusID;
	private String status;
	
	public SituationBean() {
		
	}

	public SituationBean(String status) {
		super();
		this.status = status;
	}

	
	
	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
