package com.campingmapping.team4.spring.t4_36Mall.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Entity
@Table
public class ProductOrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seqno;
	// 訂單清單(pk)
	private Integer orderID;
	// 訂單編號(fk)
	private Integer Pd_id;
	// 產品編號(fk)
	private String Pd_name;
	// 產品名稱(fk)
	private Double discount;
	// 折扣
	private Double Pd_price;
	// 單價
	private Integer amount;
	// 數量

	private String title;

}
