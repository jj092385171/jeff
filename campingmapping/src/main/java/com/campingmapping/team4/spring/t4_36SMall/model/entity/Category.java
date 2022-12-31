package com.campingmapping.team4.spring.t4_36SMall.model.entity;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//商品列表
@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pdid")
	private Integer pdid;
	// 產品編號(pk)
	@Column(name = "userID")
	private String userID;
	// 會員 ID(fk)
	@Column(name = "pdname")
	private String pdname;
	// 產品名稱
	@Column(name = "pdtitle")
	private String pdtitle;
	// 品牌名稱
	@Column(name = "pdcontent")
	private String pdcontent;
	// 產品規格
	@Column(name = "pdtype")
	private String pdtype;
	// 產品類型
	@Column(name = "pdpicture")
	private Blob pdpicture;
	// 照片 vinbinary
	@Column(name = "pdprice")
	private int pdprice;
	// 價位
	@Column(name = "pdinventory")
	private int pdinventory;
	// 庫存數量
	@Column(name = "pddate")
	private Date pddate;
	// 商品建立日期
	@Column(name = "pdlastupdate")
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

	public Category(Integer pdid, String userID, String pdname, String pdtitle, String pdcontent, String pdtype,
			Blob pdpicture, int pdprice, int pdinventory, Date pddate, Date pdlastupdate) {
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
	}

	@Override
	public String toString() {
		return "Category [pdid=" + pdid + ", userID=" + userID + ", pdname=" + pdname + ", pdtitle=" + pdtitle
				+ ", pdcontent=" + pdcontent + ", pdtype=" + pdtype + ", pdpicture=" + pdpicture + ", pdprice="
				+ pdprice + ", pdinventory=" + pdinventory + ", pddate=" + pddate + ", pdlastupdate=" + pdlastupdate
				+ "]";
	}

}
