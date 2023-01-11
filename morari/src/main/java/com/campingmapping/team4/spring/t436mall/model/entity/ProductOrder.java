package com.campingmapping.team4.spring.t436mall.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productOrder")
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderID")
	private int orderID;
	// 訂單編號(pk)
	@Column(name = "Pdid")
	private int Pdid;
	// 產品編號(fk)
	@Column(name = "privateOdstatus")
	private String privateOdstatus;
	// 訂單狀態
	@Column(name = "datetime")
	private Date datetime;
	// 訂單日期
	@Column(name = "odlastupdate")
	private Date odlastupdate;
	// 訂單更新日期
	@Column(name = "userid")
	private int userid;
	// 會員(fk)
	@Column(name = "price")
	private int price;
	// 價位(fk)
	@Column(name = "money")
	private int money;
	// 總計
	@Column(name = "odshippingaddress")
	private String odshippingaddress;
	// 運送位置
	@Column(name = "odshippingpostalcode")
	private String odshippingpostalcode;
	// 郵遞區號
	@Column(name = "odshippingcost")
	private int odshippingcost;
	// 運送費用

}
