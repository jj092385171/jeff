//package com.campingmapping.team4.spring.t4_01Member.model.entity;
//
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//// loginhistory
////登入歷史
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "loginhistory")
//public class LoginHistory {
//	
//	
//	// lhid 
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "lhid")
//	private Integer lhid; 
//	//uid
////	@Column(name = "uid")
////	private Integer uid;
//	// account 
//	//帳號
//	@Column(name = "account")
//	private String account;
//	// ip 
//	//IP位置
//	@Column(name = "ip")
//	private String ip;
//	// logindate 
//	//登入時間
//	@Column(name = "logindate")
//	private Date logindate;
//	// show 
//	@Column(name = "show")
//	private String show;
//	@ManyToOne
//	@JoinColumn(name = "uid")
//	private Member member;
//	@Override
//	public String toString() {
//		return String.format(
//				"LoginHistory [lhid=%s, uid=%s, account=%s, ip=%s, logindate=%s, show=%s]",
//				lhid, member.getUid(), account, ip, logindate, show);
//	}
//	
////	@ManyToOne
////	@JoinColumn(name = "member_uid")
////	private Member member;
//	
//	
//	
//	
//	
//}
