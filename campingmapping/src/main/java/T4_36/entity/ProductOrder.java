package T4_36.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProductOrder {

	private int orderID;
	// 訂單編號(pk)
	private String Od_status;
	// 訂單狀態
	private Date od_date;
	// 訂單日期
	private Date od_last_update;
	// 訂單更新日期
	private String user_id;
	// 會員 id(fk)
	private String od_shipping_name;
	// 顧客姓名(fk)
	private Double Pd_price;
	// 價格
	private String od_shipping_address;
	// 運送位置
	private String od_shipping_email;
	// 顧客電子郵件(fk)
	private String od_shipping_phone;
	// 顧客電話(fk)
	private String od_shipping_postal_code;
	// 郵遞區號
	private Double od_shipping_cost;
	// 運送費用
	Set<ProductOrderItems> items = new LinkedHashSet<>();

	public ProductOrder() {

	}

	public ProductOrder(Integer no, String od_status, Date od_date, Date od_last_update, String user_id,
			String od_shipping_name, Double pd_price, String od_shipping_address, String od_shipping_email,
			String od_shipping_phone, String od_shipping_postal_code, Double od_shipping_cost, Set<ProductOrderItems> items) {
		super();
		this.orderID = no;
		this.Od_status = od_status;
		this.od_date = od_date;
		this.od_last_update = od_last_update;
		this.user_id = user_id;
		this.od_shipping_name = od_shipping_name;
		this.Pd_price = pd_price;
		this.od_shipping_address = od_shipping_address;
		this.od_shipping_email = od_shipping_email;
		this.od_shipping_phone = od_shipping_phone;
		this.od_shipping_postal_code = od_shipping_postal_code;
		this.od_shipping_cost = od_shipping_cost;
		this.items = items;
	}

	public Set<ProductOrderItems> getItems() {
		return items;
	}

	public void setItems(Set<ProductOrderItems> items) {
		this.items = items;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getOd_status() {
		return Od_status;
	}

	public void setOd_status(String od_status) {
		Od_status = od_status;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Date getOd_date() {
		return od_date;
	}

	public void setOd_date(Date od_date) {
		this.od_date = od_date;
	}

	public Date getOd_last_update() {
		return od_last_update;
	}

	public void setOd_last_update(Date od_last_update) {
		this.od_last_update = od_last_update;
	}

	public String getOd_shipping_name() {
		return od_shipping_name;
	}

	public void setOd_shipping_name(String od_shipping_name) {
		this.od_shipping_name = od_shipping_name;
	}

	public Double getPd_price() {
		return Pd_price;
	}

	public void setPd_price(Double pd_price) {
		Pd_price = pd_price;
	}

	public String getOd_shipping_address() {
		return od_shipping_address;
	}

	public void setOd_shipping_address(String od_shipping_address) {
		this.od_shipping_address = od_shipping_address;
	}

	public String getOd_shipping_email() {
		return od_shipping_email;
	}

	public void setOd_shipping_email(String od_shipping_email) {
		this.od_shipping_email = od_shipping_email;
	}

	public String getOd_shipping_phone() {
		return od_shipping_phone;
	}

	public void setOd_shipping_phone(String od_shipping_phone) {
		this.od_shipping_phone = od_shipping_phone;
	}

	public String getOd_shipping_postal_code() {
		return od_shipping_postal_code;
	}

	public void setOd_shipping_postal_code(String od_shipping_postal_code) {
		this.od_shipping_postal_code = od_shipping_postal_code;
	}

	public Double getOd_shipping_cost() {
		return od_shipping_cost;
	}

	public void setOd_shipping_cost(Double od_shipping_cost) {
		this.od_shipping_cost = od_shipping_cost;
	}

}
