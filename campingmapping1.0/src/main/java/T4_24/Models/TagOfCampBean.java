package T4_24.Models;

public class TagOfCampBean {

	private int tagID;
	private int campID;
	
	
	public TagOfCampBean() {
	}


	public TagOfCampBean(int tagID, int campID) {
		super();
		this.tagID = tagID;
		this.campID = campID;
	}


	public int getTagID() {
		return tagID;
	}


	public void setTagID(int tagID) {
		this.tagID = tagID;
	}


	public int getCampID() {
		return campID;
	}


	public void setCampID(int campID) {
		this.campID = campID;
	}

	
	
}
