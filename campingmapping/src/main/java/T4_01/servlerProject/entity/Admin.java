package T4_01.servlerProject.entity;

public class Admin {
	private int UID;
	private String password;

	public Admin() {

	}

	public Admin(int UID, String password) {

		this.UID = UID;
		this.password = password;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int UID) {
		this.UID = UID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Admin [UID=%s, password=%s]", UID, password);
	}

	

}
