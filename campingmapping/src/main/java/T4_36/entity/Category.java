package T4_36.entity;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Category {

	private Integer Pd_id;
	// 產品編號(pk)
	private String userID;
	// 會員 ID(fk)
	private String name;
	// 產品名稱
	private String title;
	// 品牌名稱
	private String Pd_content;
	// 產品規格
	private String type;
	// 產品類型
	private Blob picture;
	// 照片 vinbinary
	private int price;
	// 價位
	private int inventory;
	// 庫存數量
	private static Date Pd_date;
	// 商品建立日期
	private static Date Pd_last_update;
	// 商品更新日期

	public int getPd_id() {
		return Pd_id;
	}

	public Category() {
		
	}
	
	
	public Category(String userID, String name, String title, String Pd_content, String type, Blob picture, int price,
			int inventory, Date pd_date, Date pd_last_update) {
		super();
		this.userID = userID;
		this.name = name;
		this.title = title;
		this.Pd_content = Pd_content;
		this.type = type;
		this.picture = picture;
		this.price = price;
		this.inventory = inventory;
		Pd_date = pd_date;
		Pd_last_update = pd_last_update;
	}


	public Category(Integer pd_id, String userID, String name, String title, String Pd_content, String type, Blob picture,
					int price, int inventory, Date pd_date, Date pd_last_update) {
		super();
		this.Pd_id = pd_id;
		this.userID = userID;
		this.name = name;
		this.title = title;
		this.Pd_content = Pd_content;
		this.type = type;
		this.picture = picture;
		this.price = price;
		this.inventory = inventory;
		Pd_date = pd_date;
		Pd_last_update = pd_last_update;
	}

	public Category(String userID2, String name2, String title2, String content, String type2, Blob picture2,
			int price2, int inventory2, SimpleDateFormat sd, SimpleDateFormat sd1) {
		// TODO Auto-generated constructor stub
	}

	private String priceStr = null;

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	
	public void setPd_id(int pd_id) {
		Pd_id = pd_id;
	}

	public String getuserID() {
		return userID;
	}

	public void setID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Pd_content;
	}

	public void setContent(String Pd_content) {
		this.Pd_content = Pd_content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public Date getPd_date() {
		return Pd_date;
	}

	public static void setPd_date(Date pd_date) {
		Pd_date = pd_date;
	}

	public Date getPd_last_update() {
		return Pd_last_update;
	}

	public static void setPd_last_update(Date pd_last_update) {
		Pd_last_update = pd_last_update;
	}

	@Override
	public String toString() {
		return "category [Pd_id=" + Pd_id + ", userID=" + userID + ", name=" + name + ", title=" + title + ", content="
				+ Pd_content + ", type=" + type + ", picture=" + picture + ", price=" + price + ", inventory=" + inventory
				+ ", Pd_date=" + Pd_date + ", Pd_last_update=" + Pd_last_update + "]";
	}

}
