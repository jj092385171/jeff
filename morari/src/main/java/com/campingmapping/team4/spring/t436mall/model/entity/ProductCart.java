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
@Table(name = "productcart")
public class ProductCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private int cartid;
	// 購物車編號(pk)
	@Column(name = "userid")
	private int userid;
	// 會員 ID(fk)
	@Column(name = "pdid")
	private Integer pdid;
	// 產品編號(fk)
	@Column(name = "ctqty")
	private int ctqty;
	// 數量
	@Column(name = "money")
	private int money;
	// 總計金額

}
