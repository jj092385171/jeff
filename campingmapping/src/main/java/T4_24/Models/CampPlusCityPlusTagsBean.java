package T4_24.Models;

import java.sql.Blob;
import java.util.List;

public class CampPlusCityPlusTagsBean {

	private Integer campID;
	private String campName;
	private Integer cityID;
	private String cityName;
	private String location;
	private java.sql.Blob campPictures;
	private String discription;
	private List<TagPlusCampBean> tagList;
	
	
	public CampPlusCityPlusTagsBean() {
	}


	public CampPlusCityPlusTagsBean(String campName, Integer cityID, String location, Blob campPictures,
			String discription, List<TagPlusCampBean> tagList) {
		super();
		this.campName = campName;
		this.cityID = cityID;
		this.location = location;
		this.campPictures = campPictures;
		this.discription = discription;
		this.tagList = tagList;
	}


	public Integer getCampID() {
		return campID;
	}


	public void setCampID(Integer campID) {
		this.campID = campID;
	}


	public String getCampName() {
		return campName;
	}


	public void setCampName(String campName) {
		this.campName = campName;
	}


	public Integer getCityID() {
		return cityID;
	}


	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public java.sql.Blob getCampPictures() {
		return campPictures;
	}


	public void setCampPictures(java.sql.Blob campPictures) {
		this.campPictures = campPictures;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public List<TagPlusCampBean> getTagList() {
		return tagList;
	}


	public void setTagList(List<TagPlusCampBean> tagList) {
		this.tagList = tagList;
	}

	
	
	
	
}
