package T4_09._04_licenseOrd.model;

import java.util.Date;

public class licenseOrdBean {

	private int uID;//會員
	private Date ordDate;//訂單日期
	private int ordID;//訂單編號
	private int total;//總金額
	private int proID;//產品編號
	private int itemPrice;//小計
	private int price;//訂購價格
	private Date starDate;//開始日
	private Date endDate;//結束日
	private String decribe;//描述

	public licenseOrdBean(){
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public int getOrdID() {
		return ordID;
	}

	public void setOrdID(int ordID) {
		this.ordID = ordID;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDecribe() {
		return decribe;
	}

	public void setDecribe(String decribe) {
		this.decribe = decribe;
	}

	public licenseOrdBean(int uID, Date ordDate, int ordID, int total, int proID, int itemPrice, int price,
			Date starDate, Date endDate, String decribe) {
		super();
		this.uID = uID;
		this.ordDate = ordDate;
		this.ordID = ordID;
		this.total = total;
		this.proID = proID;
		this.itemPrice = itemPrice;
		this.price = price;
		this.starDate = starDate;
		this.endDate = endDate;
		this.decribe = decribe;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("licenseOrdBean [uID=");
		builder.append(uID);
		builder.append(", ordDate=");
		builder.append(ordDate);
		builder.append(", ordID=");
		builder.append(ordID);
		builder.append(", total=");
		builder.append(total);
		builder.append(", proID=");
		builder.append(proID);
		builder.append(", itemPrice=");
		builder.append(itemPrice);
		builder.append(", price=");
		builder.append(price);
		builder.append(", starDate=");
		builder.append(starDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", decribe=");
		builder.append(decribe);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
