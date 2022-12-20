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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

//會員
@Entity
@Table(name = "member")
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

//	@OneToOne(mappedBy = "member")
////	@PrimaryKeyJoinColumn
//	private Limits limits;
//
//	@OneToOne(mappedBy = "member")
//	private Limits limitsA;
	
//	@OneToOne(mappedBy = "member")
//	@PrimaryKeyJoinColumn
//	private License license;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	@OrderBy("logindate desc")
	private Set<LoginHistory> loginHistories = new LinkedHashSet<LoginHistory>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	@OrderBy("cwid desc")
	private Set<CouponWallet> couponWallet = new LinkedHashSet<CouponWallet>();

	public Member() {
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getLeavel() {
		return leavel;
	}

	public void setLeavel(Integer leavel) {
		this.leavel = leavel;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getRegisterdata() {
		return registerdata;
	}

	public void setRegisterdata(Date registerdata) {
		this.registerdata = registerdata;
	}

	public String getSubscribed() {
		return subscribed;
	}

	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}

	public Blob getShot() {
		return shot;
	}

	public void setShot(Blob shot) {
		this.shot = shot;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

//	public Limits getLimits() {
//		return limits;
//	}
//
//	public void setLimits(Limits limits) {
//		this.limits = limits;
//	}

//	public License getLicense() {
//		return license;
//	}
//
//	public void setLicense(License license) {
//		this.license = license;
//	}

	public Set<LoginHistory> getLoginHistories() {
		return loginHistories;
	}

	public void setLoginHistories(Set<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
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
				"Member [uid=%s, account=%s, nickname=%s, firstname=%s, lastname=%s, exp=%s, leavel=%s, point=%s, phone=%s, birthday=%s, address=%s, email=%s, gender=%s, registerdata=%s, subscribed=%s, shot=%s, show=%s, about=%s]",
				uid, account, nickname, firstname, lastname, exp, leavel, point,
				phone, birthday, address, email, gender, registerdata,
				subscribed, shot, show, about);
	}

}