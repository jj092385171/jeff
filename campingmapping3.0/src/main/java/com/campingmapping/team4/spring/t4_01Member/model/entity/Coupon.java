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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// coupon
//折價券
@Getter
@Setter
@NoArgsConstructor
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

	
	@Override
	public String toString() {
		return String.format(
				"Coupon [couponid=%s, couponcode=%s, couponname=%s, coupontype=%s, couponamount=%s, couponused=%s, couponrule=%s, startdate=%s, enddate=%s, show=%s, state=%s]",
				couponid, couponcode, couponname, coupontype, couponamount, couponused, couponrule, startdate, enddate,
				show, state);
	}



	
	

}
