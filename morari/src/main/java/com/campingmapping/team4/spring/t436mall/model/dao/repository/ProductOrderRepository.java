package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrder;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderVo;

import java.lang.String;

public interface ProductOrderRepository extends	JpaRepository<ProductOrder, Integer> {

	// 根據購物車新增一筆訂單
	// 依userID來修改單筆產品(只有後臺能使用)
	// 依orderID來搜尋單筆訂單
	@Query(value = "SELECT p.id, p.userid, d.pdid, d.pdqty, c.pdpicture, c.pdprice, c.pdname"
			+ " FROM productorder p"
			+ " LEFT JOIN productorderdetail d ON  p.id = d.pdorderid"
			+" LEFT JOIN category c ON d.pdid = c.pdid WHERE p.id= ?1", nativeQuery = true)
	public List<ProductOrderVo> findById(String id);
	// 依userID來搜尋所有訂單
	public List<ProductOrder> findByUserid(String userid);
	// 搜尋所有訂單(只有後臺能使用)
	// 修改訂單出貨地址、收件人、手機號(只有後臺能使用)
	@Modifying
	@Query(value = "update productorder set orderstatus = ?1 newdate = ?2 where id = ?3", nativeQuery = true)
	public void updateProductOrderSatusById(String orderStatus, Date newDate, String orderId);

}
