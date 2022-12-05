package T4_24.Models;

public class TagOfCampBean {

	private String tagID;
	private String campID;
	
	
	public TagOfCampBean() {
	}


	public TagOfCampBean(String tagID, String campID) {
		super();
		this.tagID = tagID;
		this.campID = campID;
	}


	public String getTagID() {
		return tagID;
	}


	public void setTagID(String tagID) {
		this.tagID = tagID;
	}


	public String getCampID() {
		return campID;
	}


	public void setCampID(String campID) {
		this.campID = campID;
	}
	
	
	
	
	
}
