package T4_24.Models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.IOUtils;


public class CampBean {
	
	private int campID;
	private String campName;
	private int cityID;
	private String location;
	private InputStream campPictures;
	private String discription;
	
	
	public CampBean(){
		
	}

	public CampBean(String campName, int cityID, String location, InputStream campPictures, String discription) {
		super();
		this.campName = campName;
		this.cityID = cityID;
		this.location = location;
		this.campPictures = campPictures;
		this.discription = discription;
	}


	
	public int getCampID() {
		return campID;
	}

	public void setCampID(int campID) {
		this.campID = campID;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
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
	
	

	public String getBinaryString() throws IOException {
		byte[] sourceBytes = IOUtils.toByteArray(campPictures);
		System.out.println(sourceBytes);
		System.out.println(campPictures);
		String encodedString = Base64.getEncoder().encodeToString(sourceBytes); 
		System.out.println(encodedString);
		return encodedString;
	}
	
	
}
