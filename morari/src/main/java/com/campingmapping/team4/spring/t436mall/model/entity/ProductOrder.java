package com.campingmapping.team4.spring.t436mall.model.entity;

import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productorder")
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;
	// 序號(pk)
	@Column(name = "orderid")
	private int orderid;
	// 訂單編號(pk)
	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonIgnoreProperties("category")
	private UserProfiles userprofiles;
	// 會員 ID(fk)
	@Column(name = "privateodstatus")
	private String privateodstatus;
	// 訂單狀態
	@Column(name = "datetime")
	private Date datetime;
	// 訂單日期
	@Column(name = "money")
	private int money;
	// 總計
	@Column(name = "odshippingaddress")
	private String odshippingaddress;
	// 運送位置
	@Column(name = "odrecipient")
	private String odrecipient;
	// 收件人名稱
	@Column(name = "odrecipientphone")
	private String odrecipientphone;
	// 收件人電話

}
