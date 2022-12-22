package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// license
@Entity
@Table(name = "license")
public class License {
	// uid 
	@Id
	@Column(name = "uid")
	private Integer uid;
	// account 
	@Column(name = "account",insertable = false, updatable = false)
	private String account;
	// facebookid
	@Column(name = "facebookid")
	private String facebookid;
	// googleid 
	@Column(name = "googleid")
	private String googleid;
	// lineid
	@Column(name = "lineid")
	private String lineid;
	// password 
	@Column(name = "password")
	private String password;
	// show 
	@Column(name = "show")
	private String show;
	// ALTER TABLE [dbo].[license]  WITH CHECK ADD  CONSTRAINT [fk_member_license_account] FOREIGN KEY([account])
	// REFERENCES [dbo].[member] ([account])
	// ALTER TABLE [dbo].[license]  WITH NOCHECK ADD  CONSTRAINT [fk_member_license_uid] FOREIGN KEY([UID])
	// REFERENCES [dbo].[member] ([uid])
	// NOT FOR REPLICATION 
//	@JoinColumn(name = "fk_member_license_account")
	@OneToOne
	@MapsId
	@JoinColumn(name = "uid")
	private Member member;
	
	@OneToOne
	@JoinColumn(name = "account")
	private Member memberA;

//	@OneToOne(mappedBy = "license")
	
	public License() {

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

	public String getFacebookid() {
		return facebookid;
	}

	public void setFacebookid(String facebookid) {
		this.facebookid = facebookid;
	}

	public String getGoogleid() {
		return googleid;
	}

	public void setGoogleid(String googleid) {
		this.googleid = googleid;
	}

	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return String.format(
				"License [uid=%s, account=%s, facebookid=%s, googleid=%s, lineid=%s, password=%s, show=%s]", uid,
				account, facebookid, googleid, lineid, password, show);
	}



	

}
