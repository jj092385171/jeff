package T4_24.Models;

import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;

public class CampBean {
	
	private String campName;
	private String city;
	private String location;
	private InputStream campPictures;
	private String discription;
	
	
	public CampBean(){
		
	}


	public CampBean(String campName, String city, String location, InputStream campPictures, String discription) {
		super();
		this.campName = campName;
		this.city = city;
		this.location = location;
		this.campPictures = campPictures;
		this.discription = discription;
	}


	public String getCampName() {
		return campName;
	}


	public void setCampName(String campName) {
		this.campName = campName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public InputStream getCampPictures() {
		return campPictures;
	}


	public void setCampPictures(InputStream campPictures) {
		this.campPictures = campPictures;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
	

	
}
