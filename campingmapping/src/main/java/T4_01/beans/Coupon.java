package T4_01.beans;

import java.util.Date;
//折價券
public class Coupon {
//	ID
private int couponID;
//折扣碼
private String couponCode;
//券名
private String couponName;
//類型
private int couponType;
//發放數量
private int couponAmount;
//使用數量
private int couponUsed;
//規則
private String couponRule;
//開始日期
private Date startDate;
//結束日期
private Date endDate;
public Coupon() {
	super();
}
public Coupon(int couponID, String couponCode, String couponName,
		int couponType, int couponAmount, int couponUsed, String couponRule,
		Date startDate, Date endDate) {
	super();
	this.couponID = couponID;
	this.couponCode = couponCode;
	this.couponName = couponName;
	this.couponType = couponType;
	this.couponAmount = couponAmount;
	this.couponUsed = couponUsed;
	this.couponRule = couponRule;
	this.startDate = startDate;
	this.endDate = endDate;
}
public int getCouponID() {
	return couponID;
}
public void setCouponID(int couponID) {
	this.couponID = couponID;
}
public String getCouponCode() {
	return couponCode;
}
public void setCouponCode(String couponCode) {
	this.couponCode = couponCode;
}
public String getCouponName() {
	return couponName;
}
public void setCouponName(String couponName) {
	this.couponName = couponName;
}
public int getCouponType() {
	return couponType;
}
public void setCouponType(int couponType) {
	this.couponType = couponType;
}
public int getCouponAmount() {
	return couponAmount;
}
public void setCouponAmount(int couponAmount) {
	this.couponAmount = couponAmount;
}
public int getCouponUsed() {
	return couponUsed;
}
public void setCouponUsed(int couponUsed) {
	this.couponUsed = couponUsed;
}
public String getCouponRule() {
	return couponRule;
}
public void setCouponRule(String couponRule) {
	this.couponRule = couponRule;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return String.format(
			"coupon [couponID=%s, couponCode=%s, couponName=%s, couponType=%s, couponAmount=%s, couponUsed=%s, couponRule=%s, startDate=%s, endDate=%s]",
			couponID, couponCode, couponName, couponType, couponAmount,
			couponUsed, couponRule, startDate, endDate);
}


}


