package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//票券夾
// couponwallet
@Getter
@Setter
@NoArgsConstructor
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
	@JoinColumn(name = "coupon_couponid")
	private Coupon coupon;
	// ALTER TABLE [dbo].[couponwallet] WITH CHECK ADD CONSTRAINT
	// [fk_member_couponWallet_uid] FOREIGN KEY([uid])
	// REFERENCES [dbo].[member] ([uid])
	@ManyToOne
	@JoinColumn(name = "member_uid")
	private Member member;


	@Override
	public String toString() {
		return String.format("CouponWallet [cwid=%s, uid=%s, couponid=%s, state=%s, show=%s]", cwid, uid, couponid,
				state, show);
	}



	
	

}
