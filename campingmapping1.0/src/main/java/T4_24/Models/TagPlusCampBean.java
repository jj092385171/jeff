package T4_24.Models;

public class TagPlusCampBean {
	
	private int campID;
	private int tagID;
	private String tagName;
	
	
	public TagPlusCampBean() {
	}


	public TagPlusCampBean(int campID, int tagID, String tagName) {
		super();
		this.campID = campID;
		this.tagID = tagID;
		this.tagName = tagName;
	}


	public int getCampID() {
		return campID;
	}


	public void setCampID(int campID) {
		this.campID = campID;
	}


	public int getTagID() {
		return tagID;
	}


	public void setTagID(int tagID) {
		this.tagID = tagID;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
	
	

}
