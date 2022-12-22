package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
// coupon
//折價券
@Entity
@Table(name = "coupon")

public class Coupon {
	// couponid
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "couponid")
	private Integer couponid;
	// couponcode
	// 折扣碼
	@Column(name = "couponcode")
	private String couponcode;
	// couponname
	// 券名
	@Column(name = "couponname")
	private String couponname;
	// coupontype
	// 類型
	@Column(name = "coupontype")
	private int coupontype;
	// couponamount
	// 發放數量
	@Column(name = "couponamount")
	private int couponamount;
	// couponused
	// 使用數量
	@Column(name = "couponused")
	private int couponused;
	// couponrule
	// 規則
	@Column(name = "couponrule")
	private String couponrule;
	// startdate
	// 開始日期
	@Column(name = "startdate")
	private Date startdate;
	// enddate
	// 結束日期
	@Column(name = "enddate")
	private Date enddate;
	// show
	// 建置日期
	@Column(name = "show")
	private Date show;
	// state
	@Column(name = "state")
	private String state;
	// couponphoto
	// 票券圖案
	@Column(name = "couponphoto")
	private String couponphoto;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coupon")
	@OrderBy("cwid desc")
	private Set<CouponWallet> couponWallet = new LinkedHashSet<CouponWallet>();

	public Coupon() {
	}

	public Integer getCouponid() {
		return couponid;
	}

	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public int getCoupontype() {
		return coupontype;
	}

	public void setCoupontype(int coupontype) {
		this.coupontype = coupontype;
	}

	public int getCouponamount() {
		return couponamount;
	}

	public void setCouponamount(int couponamount) {
		this.couponamount = couponamount;
	}

	public int getCouponused() {
		return couponused;
	}

	public void setCouponused(int couponused) {
		this.couponused = couponused;
	}

	public String getCouponrule() {
		return couponrule;
	}

	public void setCouponrule(String couponrule) {
		this.couponrule = couponrule;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getShow() {
		return show;
	}

	public void setShow(Date show) {
		this.show = show;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCouponphoto() {
		return couponphoto;
	}

	public void setCouponphoto(String couponphoto) {
		this.couponphoto = couponphoto;
	}

	public Set<CouponWallet> getCouponWallet() {
		return couponWallet;
	}

	public void setCouponWallet(Set<CouponWallet> couponWallet) {
		this.couponWallet = couponWallet;
	}

	@Override
	public String toString() {
		return String.format(
				"Coupon [couponid=%s, couponcode=%s, couponname=%s, coupontype=%s, couponamount=%s, couponused=%s, couponrule=%s, startdate=%s, enddate=%s, show=%s, state=%s]",
				couponid, couponcode, couponname, coupontype, couponamount, couponused, couponrule, startdate, enddate,
				show, state);
	}



	
	

}
