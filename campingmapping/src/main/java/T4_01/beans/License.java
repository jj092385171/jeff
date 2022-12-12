package T4_01.beans;

public class License {
	private int UID;
	private String account;
	private String FaceBookID;
	private String GoogleID;
	private String LineID;
	private String password;
	public License() {
		
	}
	public License(int uID, String account, String faceBookID,
			String googleID, String lineID, String password) {
		
		UID = uID;
		this.account = account;
		FaceBookID = faceBookID;
		GoogleID = googleID;
		LineID = lineID;
		this.password = password;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFaceBookID() {
		return FaceBookID;
	}
	public void setFaceBookID(String faceBookID) {
		FaceBookID = faceBookID;
	}
	public String getGoogleID() {
		return GoogleID;
	}
	public void setGoogleID(String googleID) {
		GoogleID = googleID;
	}
	public String getLineID() {
		return LineID;
	}
	public void setLineID(String lineID) {
		LineID = lineID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return String.format(
				"LicenseDao [UID=%s, account=%s, FaceBookID=%s, GoogleID=%s, LineID=%s, password=%s]",
				UID, account, FaceBookID, GoogleID, LineID, password);
	}
	
	
	
	
}
