package T4_36.entity;

import java.sql.Blob;
import java.util.Date;

public class Category {

	private Integer pdid;
	// 產品編號(pk)
	private String userID;
	// 會員 ID(fk)
	private String pdname;
	// 產品名稱
	private String pdtitle;
	// 品牌名稱
	private String pdcontent;
	// 產品規格
	private String pdtype;
	// 產品類型
	private Blob pdpicture;
	// 照片 vinbinary
	private int pdprice;
	// 價位
	private int pdinventory;
	// 庫存數量
	private Date pddate;
	// 商品建立日期
	private Date pdlastupdate;
	// 商品更新日期

	public Category() {

	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPdname() {
		return pdname;
	}

	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	public String getPdtitle() {
		return pdtitle;
	}

	public void setPdtitle(String pdtitle) {
		this.pdtitle = pdtitle;
	}

	public String getPdcontent() {
		return pdcontent;
	}

	public void setPdcontent(String pdcontent) {
		this.pdcontent = pdcontent;
	}

	public String getPdtype() {
		return pdtype;
	}

	public void setPdtype(String pdtype) {
		this.pdtype = pdtype;
	}

	public Blob getPdpicture() {
		return pdpicture;
	}

	public void setPdpicture(Blob pdpicture) {
		this.pdpicture = pdpicture;
	}

	public int getPdprice() {
		return pdprice;
	}

	public void setPdprice(int pdprice) {
		this.pdprice = pdprice;
	}

	public int getPdinventory() {
		return pdinventory;
	}

	public void setPdinventory(int pdinventory) {
		this.pdinventory = pdinventory;
	}

	public Date getPddate() {
		return pddate;
	}

	public void setPddate(Date pddate) {
		this.pddate = pddate;
	}

	public Date getPdlastupdate() {
		return pdlastupdate;
	}

	public void setPdlastupdate(Date pdlastupdate) {
		this.pdlastupdate = pdlastupdate;
	}

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	private String priceStr = null;

	public Category(Integer pdid, String userID, String pdname, String pdtitle, String pdcontent, String pdtype,
			int pdprice, int pdinventory, Date pdlastupdate) {
		super();
		this.pdid = pdid;
		this.userID = userID;
		this.pdname = pdname;
		this.pdtitle = pdtitle;
		this.pdcontent = pdcontent;
		this.pdtype = pdtype;
		this.pdprice = pdprice;
		this.pdinventory = pdinventory;
		this.pdlastupdate = pdlastupdate;
	}

	public Category(String userID, String pdname, String pdtitle, String pdcontent, String pdtype, int pdprice,
			int pdinventory, Date pdlastupdate) {
		super();
		this.userID = userID;
		this.pdname = pdname;
		this.pdtitle = pdtitle;
		this.pdcontent = pdcontent;
		this.pdtype = pdtype;
		this.pdprice = pdprice;
		this.pdinventory = pdinventory;
		this.pdlastupdate = pdlastupdate;
	}

	public Category(String userID, String pdname, String pdtitle, String pdcontent, String pdtype, Blob pdpicture,
			int pdprice, int pdinventory, Date pddate, Date pdlastupdate) {
		super();
		this.userID = userID;
		this.pdname = pdname;
		this.pdtitle = pdtitle;
		this.pdcontent = pdcontent;
		this.pdtype = pdtype;
		this.pdpicture = pdpicture;
		this.pdprice = pdprice;
		this.pdinventory = pdinventory;
		this.pddate = pddate;
		this.pdlastupdate = pdlastupdate;
	}

	public Category(Integer pdid, String userID, String pdname, String pdtitle, String pdcontent, String pdtype,
			Blob pdpicture, int pdprice, int pdinventory, Date pddate, Date pdlastupdate, String priceStr) {
		super();
		this.pdid = pdid;
		this.userID = userID;
		this.pdname = pdname;
		this.pdtitle = pdtitle;
		this.pdcontent = pdcontent;
		this.pdtype = pdtype;
		this.pdpicture = pdpicture;
		this.pdprice = pdprice;
		this.pdinventory = pdinventory;
		this.pddate = pddate;
		this.pdlastupdate = pdlastupdate;
		this.priceStr = priceStr;
	}

	@Override
	public String toString() {
		return "Category [pdid=" + pdid + ", userID=" + userID + ", pdname=" + pdname + ", pdtitle=" + pdtitle
				+ ", pdcontent=" + pdcontent + ", pdtype=" + pdtype + ", pdpicture=" + pdpicture + ", pdprice="
				+ pdprice + ", pdinventory=" + pdinventory + ", pddate=" + pddate + ", pdlast_update=" + pdlastupdate
				+ ", priceStr=" + priceStr + "]";
	}

}
