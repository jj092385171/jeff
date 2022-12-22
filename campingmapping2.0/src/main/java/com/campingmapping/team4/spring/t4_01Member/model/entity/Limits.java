package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

// limits
//權限
@Data
@NoArgsConstructor
@Entity
@Table(name = "limits")
public class Limits {
	// uid
	@Id
	@Column(name = "uid")
	private Integer uid;
	// account
	// 帳號
	@Column(name = "account", insertable = false, updatable = false)
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
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_account] FOREIGN KEY([account])
	// REFERENCES [dbo].[member] ([account])
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_uid] FOREIGN KEY([uid])
	// REFERENCES [dbo].[member] ([uid])
	// @JoinColumn(name = "fk_member_limits_account")
	
	
	
	

}
