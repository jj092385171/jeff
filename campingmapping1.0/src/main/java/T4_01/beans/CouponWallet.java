package T4_01.beans;
//票券夾
public class CouponWallet {
//票券夾ID
private int CWID;
//擁有者ID
private int UID;
//票券ID
private int couponID;
//狀態(1.未使用 2.已使用 3.已過期 4.暫停)
private int state;

public CouponWallet() {
	super();
}

public CouponWallet(int cWID, int uID, int couponID, int state) {
	super();
	CWID = cWID;
	UID = uID;
	this.couponID = couponID;
	this.state = state;
}

public int getCWID() {
	return CWID;
}

public void setCWID(int cWID) {
	CWID = cWID;
}

public int getUID() {
	return UID;
}

public void setUID(int uID) {
	UID = uID;
}

public int getCouponID() {
	return couponID;
}

public void setCouponID(int couponID) {
	this.couponID = couponID;
}

public int getState() {
	return state;
}

public void setState(int state) {
	this.state = state;
}

@Override
public String toString() {
	return String.format(
			"couponWallet [CWID=%s, UID=%s, couponID=%s, state=%s]", CWID, UID,
			couponID, state);
}



}
