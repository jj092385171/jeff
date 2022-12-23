package T4_01.beans;

import java.sql.Blob;
import java.util.Date;

//會員
public class Member {
	// UID
	private int UID;
	// 帳號
	private String account;
	// 暱稱
	private String Nickname;
	// 名
	private String firstname;
	// 姓
	private String lastname;
	// 經驗
	private int exp;
	// 等級()
	private int leavel;
	// 點數
	private int point;
	// 手機
	private String phone;
	// 生日
	private Date birthday;
	// 居住地
	private String address;
	// 電子信箱
	private String email;
	// 性別
	private int gender;
	// 註冊日期
	private Date registerdata;
	// 訂閱(Y y/N n)
	private String subscribed;
	// 大頭像
	private Blob shot;

	public Member() {
	}
	public Member(int uID, String account, String nickname, String firstname,
			String lastname, int exp, int leavel, int point, String phone,
			Date birthday, String address, String email, int gender,
			Date registerdata, String subscribed, Blob shot) {
		super();
		UID = uID;
		this.account = account;
		Nickname = nickname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.exp = exp;
		this.leavel = leavel;
		this.point = point;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.registerdata = registerdata;
		this.subscribed = subscribed;
		this.shot = shot;
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
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLeavel() {
		return leavel;
	}
	public void setLeavel(int leavel) {
		this.leavel = leavel;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getRegisterdata() {
		return registerdata;
	}
	public void setRegisterdata(Date registerdata) {
		this.registerdata = registerdata;
	}
	public String getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}
	public Blob getShot() {
		return shot;
	}
	public void setShot(Blob shot) {
		this.shot = shot;
	}
	public void setStringBirthday(String birthday) {
		// System.out.println(birthday);
		long birthdayTime = Long.parseLong(birthday);
		// System.out.println(birthdayTime);
		Date date = new Date(birthdayTime);
		// System.out.println(date);
		this.birthday = date;
	}

	@Override
	public String toString() {
		return String.format(
				"member [UID=%s, account=%s, Nickname=%s, firstname=%s, lastname=%s, exp=%s, leavel=%s, point=%s, phone=%s, birthday=%s, address=%s, email=%s, gender=%s, registerdata=%s, subscribed=%s, shot=%s]",
				UID, account, Nickname, firstname, lastname, exp, leavel, point,
				phone, birthday, address, email, gender, registerdata,
				subscribed, shot);
	}

}