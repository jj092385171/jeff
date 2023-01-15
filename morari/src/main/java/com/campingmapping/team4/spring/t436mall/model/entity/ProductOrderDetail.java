package com.campingmapping.team4.spring.t436mall.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "productorderdetail")
public class ProductOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	// 訂單詳情編號 不顯示(pk)
	@ManyToOne
	@JoinColumn(name = "pdorderid")
	@JsonIgnore
	private ProductOrder productorder;
//	@Column(name = "orderid")
//	private String orderid;
	// 訂單編號
	@ManyToOne
	@JoinColumn(name = "pdid")
	@JsonIgnore
//	@Column(name = "pdid")
//	private Integer pdid;
	private Category category;
	// 產品編號
	@Column(name = "pdqty")
	private Integer pdqty;
	// 數量
	@Column(name = "money")
	private Integer money;
	// 總計

}
