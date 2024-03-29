package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.sql.Blob;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//會員
@Data
@NoArgsConstructor
@Entity
@Table(name = "member")
// @Component(value = "member")
public class Member {
	// uid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer uid;
	// account
	// 帳號
	@Column(name = "account")
	private String account;
	// nickname
	// 暱稱
	@Column(name = "nickname")
	private String nickname;
	// firstname
	// 名
	@Column(name = "firstname")
	private String firstname;
	// lastname
	// 姓
	@Column(name = "lastname")
	private String lastname;
	// exp
	// 經驗
	@Column(name = "exp")
	private Integer exp;
	// leavel
	// 等級()
	@Column(name = "leavel")
	private Integer leavel;
	// point
	// 點數
	@Column(name = "point")
	private Integer point;
	// phone
	// 手機
	@Column(name = "phone")
	private String phone;
	// birthday
	// 生日
	@Column(name = "birthday")
	private Date birthday;
	// address
	// 居住地
	@Column(name = "address")
	private String address;
	// email
	// 電子信箱
	@Column(name = "email")
	private String email;
	// gender
	// 性別
	@Column(name = "gender")
	private Integer gender;
	// registerdata
	// 註冊日期
	@Column(name = "registerdata")
	private Date registerdata;
	// subscribed
	// 訂閱(Y y/N n)
	@Column(name = "subscribed")
	private String subscribed;
	// shot
	// 大頭像
	@Column(name = "shot")
	private Blob shot;
	// show
	@Column(name = "show")
	private String show;
	// show
	@Column(name = "about")
	private String about;

	@OneToOne(mappedBy = "member")
	private Limits limits;
	@OneToOne
	@PrimaryKeyJoinColumn
	private License license;
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	// @JoinTable(name = "Member_LoginHistory",
	// joinColumns = {@JoinColumn(name = "memberid", referencedColumnName =
	// "uid")},
	// inverseJoinColumns = {@JoinColumn(name = "loginhistoryId",
	// referencedColumnName = "uid")})
	@OneToMany(mappedBy = "member")
	 @OrderBy("logindate desc")
	private Set<LoginHistory> loginHistories = new LinkedHashSet<LoginHistory>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	@OrderBy("cwid desc")
	private Set<CouponWallet> couponWallet = new LinkedHashSet<CouponWallet>();

}