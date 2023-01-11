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
@Table(name = "productCart")
public class ProductCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartID")
	private int cartID;
	// 購物車編號(pk)
	@Column(name = "userID")
	private String userID;
	// 會員 ID(fk)
	@Column(name = "pdid")
	private Integer pdid;
	// 產品編號(fk)
	@Column(name = "pdid")
	private int ctqty;
	// 數量
	@Column(name = "pdid")
	private String title;
	//總計金額

}
