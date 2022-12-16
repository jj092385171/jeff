package T4_24.Models;

public class TagBean {
	
	private int tagID;
	private String tagName;
	
	
	public TagBean() {
	}


	public TagBean(String tagName) {
		super();
		this.tagName = tagName;
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
