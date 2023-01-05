package com.campingmapping.team4.spring.t4_36Mall.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductOrderItems {

	private int seqno;
	// 訂單清單(pk)
	private int orderID;
	// 訂單編號(fk)
	private int Pd_id;
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
