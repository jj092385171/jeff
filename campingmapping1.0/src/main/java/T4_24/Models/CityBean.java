package T4_24.Models;

public class CityBean {
	
	private int cityID;
	private String cityName;
	
	
	public CityBean() {
	}


	public CityBean(String cityName) {
		super();
		this.cityName = cityName;
	}


	public int getCityID() {
		return cityID;
	}


	public void setCityID(int cityID) {
		this.cityID = cityID;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	

}
