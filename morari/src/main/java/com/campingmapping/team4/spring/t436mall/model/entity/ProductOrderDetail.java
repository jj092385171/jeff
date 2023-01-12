package com.campingmapping.team4.spring.t436mall.model.entity;

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
@Table(name = "productorder")
public class ProductOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private int orderid;
	// 訂單編號(pk)
	@Column(name = "pdid")
	private int pdid;
	// 產品編號(fk)
	@Column(name = "pdprice")
	private int pdprice;
	// 商品價格(fk)
	@Column(name = "pdqty")
	private int pdqty;
	// 數量
	@Column(name = "money")
	private int money;
	// 總計

}
