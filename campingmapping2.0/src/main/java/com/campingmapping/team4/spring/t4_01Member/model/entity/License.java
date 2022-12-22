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

// license
@Data
@NoArgsConstructor
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
	@JoinColumn(name = "uid")
	private Member member;
	


	

}
