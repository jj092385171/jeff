package T4_09._03_campOrd.model;

import java.util.Date;

public class campOrdBean {
	private int uID;//會員
	private Date ordDate;//訂單日期
	private int ordID;//訂單編號
	private int total;//總金額
	private int amount;//訂購數量
	private int price;//訂購價格
	private int itemPrice;//小計

	public campOrdBean(){
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("campOrdBean [uID=");
		builder.append(uID);
		builder.append(", ordDate=");
		builder.append(ordDate);
		builder.append(", ordID=");
		builder.append(ordID);
		builder.append(", total=");
		builder.append(total);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", price=");
		builder.append(price);
		builder.append(", itemPrice=");
		builder.append(itemPrice);
		builder.append("]");
		return builder.toString();
	}

	public campOrdBean(int uID, Date ordDate, int ordID, int total, int amount, int price, int itemPrice) {
		super();
		this.uID = uID;
		this.ordDate = ordDate;
		this.ordID = ordID;
		this.total = total;
		this.amount = amount;
		this.price = price;
		this.itemPrice = itemPrice;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}