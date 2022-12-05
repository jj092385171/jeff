package T4_36.category;

import java.util.Date;

public class categorybean {

	private int Pd_id;
	// 產品編號(pk)
	private int UID;
	// 會員 id(fk)
	private String name;
	// 產品名稱
	private String title;
	// 品牌名稱
	private String content;
	// 產品規格
	private String type;
	// 產品類型
	private String picture;
	// 照片 vinbinary
	private int price;
	// 價位
	private int inventory;
	// 庫存數量
	private Date Pd_date;
	// 商品建立日期
	private Date Pd_last_update;
	// 商品更新日期

	public int getPd_id() {
		return Pd_id;
	}

	public categorybean(int pd_id, int uID, String name, String title, String content, String type, String picture,
			int price, int inventory, Date pd_date, Date pd_last_update) {
		super();
		Pd_id = pd_id;
		UID = uID;
		this.name = name;
		this.title = title;
		this.content = content;
		this.type = type;
		this.picture = picture;
		this.price = price;
		this.inventory = inventory;
		Pd_date = pd_date;
		Pd_last_update = pd_last_update;
	}

	public void setPd_id(int pd_id) {
		Pd_id = pd_id;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
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
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
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

	public void setPd_date(Date pd_date) {
		Pd_date = pd_date;
	}

	public Date getPd_last_update() {
		return Pd_last_update;
	}

	public void setPd_last_update(Date pd_last_update) {
		Pd_last_update = pd_last_update;
	}

	@Override
	public String toString() {
		return "category [Pd_id=" + Pd_id + ", UID=" + UID + ", name=" + name + ", title=" + title + ", content="
				+ content + ", type=" + type + ", picture=" + picture + ", price=" + price + ", inventory=" + inventory
				+ ", Pd_date=" + Pd_date + ", Pd_last_update=" + Pd_last_update + "]";
	}

}
