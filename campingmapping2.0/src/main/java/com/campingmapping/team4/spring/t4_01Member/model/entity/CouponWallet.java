package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//票券夾
// couponwallet
@Entity
@Table(name = "couponwallet")
public class CouponWallet {

	// cwid
	// 票券夾ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cwid")
	private Integer cwid;
	// uid
	// 擁有者ID
	@Column(name = "uid")
	private Integer uid;
	// couponid
	// 票券ID
	@Column(name = "couponid")
	private Integer couponid;
	// state
	// 狀態(1.未使用 2.已使用 3.已過期 4.暫停)
	@Column(name = "state")
	private Integer state;
	// show
	@Column(name = "show")
	private String show;
	// ALTER TABLE [dbo].[couponwallet] WITH CHECK ADD CONSTRAINT
	// [fk_coupon_couponWallet_couponid] FOREIGN KEY([couponid])
	// REFERENCES [dbo].[coupon] ([couponid])
	@ManyToOne
	@JoinColumn(name = "fk_coupon_couponWallet_couponid")
	private Coupon coupon;
	// ALTER TABLE [dbo].[couponwallet] WITH CHECK ADD CONSTRAINT
	// [fk_member_couponWallet_uid] FOREIGN KEY([uid])
	// REFERENCES [dbo].[member] ([uid])
	@ManyToOne
	@JoinColumn(name = "fk_member_couponWallet_uid")
	private Member member;

	public CouponWallet() {
	}

	public Integer getCwid() {
		return cwid;
	}

	public void setCwid(Integer cwid) {
		this.cwid = cwid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getCouponid() {
		return couponid;
	}

	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}



	
	

}
