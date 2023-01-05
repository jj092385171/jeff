package com.campingmapping.team4.spring.t4_36Mall.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductOrder {

	private int orderID;
	// 訂單編號(pk)
	private String Od_status;
	// 訂單狀態
	private Date od_date;
	// 訂單日期
	private Date od_last_update;
	// 訂單更新日期
	private String user_id;
	// 會員 id(fk)
	private String od_shipping_name;
	// 顧客姓名(fk)
	private Double Pd_price;
	// 價格
	private String od_shipping_address;
	// 運送位置
	private String od_shipping_email;
	// 顧客電子郵件(fk)
	private String od_shipping_phone;
	// 顧客電話(fk)
	private String od_shipping_postal_code;
	// 郵遞區號
	private Double od_shipping_cost;
	// 運送費用
	Set<ProductOrderItems> items = new LinkedHashSet<>();

}
