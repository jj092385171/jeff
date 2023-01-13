package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// limits
//權限
@Getter
@NoArgsConstructor
@Entity
@Table(name = "limits")
public class Limits {
	// uid
	@Id
	@Column(name = "uid")
	private Integer uid;
//	// account
//	// 帳號
	@Column(name = "account")
	private String account;
	// nomore
	// 一般
	@Column(name = "nomore")
	private String nomore;
	// buy
	// 買家
	@Column(name = "buy")
	private String buy;
	// sell
	// 賣家
	@Column(name = "sell")
	private String sell;
	// publisher
	// 發文
	@Column(name = "publisher")
	private String publisher;
	// message
	// 留言
	@Column(name = "message")
	private String message;
	// enterprise
	// 雇主
	@Column(name = "enterprise")
	private String enterprise;
	// applier
	// 應徵者
	@Column(name = "applier")
	private String applier;
	// mainhoster
	// 揪團主
	@Column(name = "mainhoster")
	private String mainhoster;
	// attender
	// 參加者
	@Column(name = "attender")
	private String attender;
	// campingowner
	// 營主
	@Column(name = "campingowner")
	private String campingowner;
	// customer
	// 營地預定
	@Column(name = "customer")
	private String customer;
	// admin
	@Column(name = "admin")
	private String admin;
	// member
	@Column(name = "members")
	private String members;
	// show
	@Column(name = "show")
	private String show;
	
	@OneToOne
	@JoinColumn(name = "uid")
	private Member member;

	@Override
	public String toString() {
		return String.format(
				"Limits [uid=%s ,account=%s ,nomore=%s, buy=%s, sell=%s, publisher=%s, message=%s, enterprise=%s, applier=%s, mainhoster=%s, attender=%s, campingowner=%s, customer=%s, admin=%s, members=%s, show=%s]",
				uid, account,nomore, buy, sell, publisher, message, enterprise, applier,
				mainhoster, attender, campingowner, customer, admin, members,
				show);
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setAccount() {
//		this.account = member.getAccount();
	}

	public void setNomore(String nomore) {
		this.nomore = nomore;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	public void setMainhoster(String mainhoster) {
		this.mainhoster = mainhoster;
	}

	public void setAttender(String attender) {
		this.attender = attender;
	}

	public void setCampingowner(String campingowner) {
		this.campingowner = campingowner;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setMember(Member member) {
		this.member = member;
	} 
	
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_account] FOREIGN KEY([account])
	// REFERENCES [dbo].[member] ([account])
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_uid] FOREIGN KEY([uid])
	// REFERENCES [dbo].[member] ([uid])
	// @JoinColumn(name = "fk_member_limits_account")
	
	
	
	

}
