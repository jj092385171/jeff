package T4_36.entity;

import java.sql.Blob;
import java.util.Date;

public class Category {

	private Integer Pd_id;
	// 產品編號(pk)
	private String userID;
	// 會員 ID(fk)
	private String Pd_name;
	// 產品名稱
	private String Pd_title;
	// 品牌名稱
	private String Pd_content;
	// 產品規格
	private String Pd_type;
	// 產品類型
	private String Pd_picture;
	// 照片 vinbinary
	private int Pd_price;
	// 價位
	private int Pd_inventory;
	// 庫存數量
	private Date Pd_date;
	// 商品建立日期
	private Date Pd_last_update;
	// 商品更新日期

	public Category(Integer pd_id, String userID, String pd_name, String pd_title, String pd_content, String pd_type,
			String pd_picture, int pd_price, int pd_inventory, Date pd_date, Date pd_last_update, String priceStr) {
		super();
		Pd_id = pd_id;
		this.userID = userID;
		Pd_name = pd_name;
		Pd_title = pd_title;
		Pd_content = pd_content;
		Pd_type = pd_type;
		Pd_picture = pd_picture;
		Pd_price = pd_price;
		Pd_inventory = pd_inventory;
		Pd_date = pd_date;
		Pd_last_update = pd_last_update;
		this.priceStr = priceStr;
	}

	public Category() {

	}

//	public Category(String userID, String pd_name, String pd_title, String pd_content, String pd_type, Blob pd_picture, int pd_price,
//			int pd_inventory, Date pd_date, Date pd_last_update) {
//		super();
//		this.userID = userID;
//		this.Pd_name = pd_name;
//		this.Pd_title = pd_title;
//		this.Pd_content = pd_content;
//		this.Pd_type = pd_type;
//		this.Pd_picture = pd_picture;
//		this.Pd_price = pd_price;
//		this.Pd_inventory = pd_inventory;
//		Pd_date = pd_date;
//		Pd_last_update = pd_last_update;
//	}
	
	private String priceStr = null;

	public Integer getPd_id() {
		return Pd_id;
	}

	public void setPd_id(Integer pd_id) {
		Pd_id = pd_id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPd_name() {
		return Pd_name;
	}

	public void setPd_name(String pd_name) {
		Pd_name = pd_name;
	}

	public String getPd_title() {
		return Pd_title;
	}

	public void setPd_title(String pd_title) {
		Pd_title = pd_title;
	}

	public String getPd_content() {
		return Pd_content;
	}

	public void setPd_content(String pd_content) {
		Pd_content = pd_content;
	}

	public String getPd_type() {
		return Pd_type;
	}

	public void setPd_type(String pd_type) {
		Pd_type = pd_type;
	}

	public String getPd_picture() {
		return Pd_picture;
	}

	public void setPd_picture(String pd_picture) {
		Pd_picture = pd_picture;
	}

	public int getPd_price() {
		return Pd_price;
	}

	public void setPd_price(int pd_price) {
		Pd_price = pd_price;
	}

	public int getPd_inventory() {
		return Pd_inventory;
	}

	public void setPd_inventory(int pd_inventory) {
		Pd_inventory = pd_inventory;
	}

	public Date getPd_date() {
		return Pd_date;
	}

	public void setPd_date(Date pd_date) {
		Pd_date = pd_date;
	}

	public Date getPd_last_update() {
		return Pd_last_update;
	}

	public void setPd_last_update(Date pd_last_update) {
		Pd_last_update = pd_last_update;
	}

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	@Override
	public String toString() {
		return "Category [Pd_id=" + Pd_id + ", userID=" + userID + ", Pd_name=" + Pd_name + ", Pd_title=" + Pd_title
				+ ", Pd_content=" + Pd_content + ", Pd_type=" + Pd_type + ", Pd_picture=" + Pd_picture + ", Pd_price="
				+ Pd_price + ", Pd_inventory=" + Pd_inventory + ", Pd_date=" + Pd_date + ", Pd_last_update="
				+ Pd_last_update + ", priceStr=" + priceStr + "]";
	}

}
