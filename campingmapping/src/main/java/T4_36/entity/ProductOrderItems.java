package T4_36.entity;

public class ProductOrderItems {

	private int seqno;
	// 訂單清單(pk)
	private int orderID;
	// 訂單編號(fk)
	private int Pd_id;
	// 產品編號(fk)
	private String Pd_name;
	// 產品名稱(fk)
	private String od_shipping_name;
	// 折扣
	private int Pd_price;
	// 單價
	public ProductOrderItems(int seqno, int orderID, int pd_id, String pd_name, String od_shipping_name, int pd_price) {
		super();
		this.seqno = seqno;
		this.orderID = orderID;
		Pd_id = pd_id;
		Pd_name = pd_name;
		this.od_shipping_name = od_shipping_name;
		Pd_price = pd_price;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getPd_id() {
		return Pd_id;
	}
	public void setPd_id(int pd_id) {
		Pd_id = pd_id;
	}
	public String getPd_name() {
		return Pd_name;
	}
	public void setPd_name(String pd_name) {
		Pd_name = pd_name;
	}
	public String getOd_shipping_name() {
		return od_shipping_name;
	}
	public void setOd_shipping_name(String od_shipping_name) {
		this.od_shipping_name = od_shipping_name;
	}
	public int getPd_price() {
		return Pd_price;
	}
	public void setPd_price(int pd_price) {
		Pd_price = pd_price;
	}
	@Override
	public String toString() {
		return "productOrderItems [seqno=" + seqno + ", orderID=" + orderID + ", Pd_id=" + Pd_id + ", Pd_name="
				+ Pd_name + ", od_shipping_name=" + od_shipping_name + ", Pd_price=" + Pd_price + "]";
	}

}
