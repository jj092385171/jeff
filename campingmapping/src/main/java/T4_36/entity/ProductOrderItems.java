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
	private String discount ;
	// 折扣
	private Double Pd_price;
	// 單價
	private Integer quantity;
	// 數量
	
	private String title;
	
	
	public ProductOrderItems(int seqno, int orderID, int pd_id, String pd_name, String discount, Double pd_price,
			Integer quantity) {
		super();
		this.seqno = seqno;
		this.orderID = orderID;
		this.Pd_id = pd_id;
		this.Pd_name = pd_name;
		this.discount = discount;
		this.Pd_price = pd_price;
		this.quantity = quantity;
	}
	public ProductOrderItems(int seqno, int orderID, int pd_id, String pd_name, String discount, Double pd_price,
			Integer quantity, String title) {
		super();
		this.seqno = seqno;
		this.orderID = orderID;
		this.Pd_id = pd_id;
		this.Pd_name = pd_name;
		this.discount = discount;
		this.Pd_price = pd_price;
		this.quantity = quantity;
		this.title = title;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Double getPd_price() {
		return Pd_price;
	}
	public void setPd_price(Double pd_price) {
		Pd_price = pd_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
