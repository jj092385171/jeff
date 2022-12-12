package T4_24.Models;




public class CampBean {
	
	private Integer campID;
	private String campName;
	private int cityID;
	private String location;
	private java.sql.Blob campPictures;
	private String discription;
	

	public CampBean(){
		
	}

	public CampBean(String campName, int cityID, String location, java.sql.Blob campPictures, String discription) {
		super();
		this.campName = campName;
		this.cityID = cityID;
		this.location = location;
		this.campPictures = campPictures;
		this.discription = discription;
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
	
	

//	public String getBase64String() throws IOException, SQLException {
//		byte[] sourceBytes = IOUtils.toByteArray(campPictures.getBinaryStream());
//		String encodedString = Base64.getEncoder().encodeToString(sourceBytes); 
//		return encodedString;
//		
//	}
	
	
	
}
