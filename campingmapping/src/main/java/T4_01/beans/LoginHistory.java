package T4_01.beans;

import java.util.Date;

//登入歷史
public class LoginHistory {
//UID
	private int UID;
//帳號
	private String account;
//IP位置
	private String IP;
//登入時間
	private Date LoginDate;
	
public LoginHistory() {
	super();
}

public LoginHistory(int uID, String account, String iP, Date loginDate) {
	super();
	UID = uID;
	this.account = account;
	IP = iP;
	LoginDate = loginDate;
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

public String getIP() {
	return IP;
}

public void setIP(String iP) {
	IP = iP;
}

public Date getLoginDate() {
	return LoginDate;
}

public void setLoginDate(Date loginDate) {
	LoginDate = loginDate;
}

@Override
public String toString() {
	return String.format(
			"loginHistory [UID=%s, account=%s, IP=%s, LoginDate=%s]", UID,
			account, IP, LoginDate);
}
	
}
