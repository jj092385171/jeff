package com.campingmapping.team4.spring.t436mall.model.entity;

public interface ProductOrderVo {

	// p.id, p.userid, d.pdid, d.pdqty, c.pdpicture, c.pdprice, c.pdname
	String getid();

	String getuserid();

	Integer getpdid();

	Integer getpdqty();

	String getpdpicture();

	Integer getpdprice();

	String getpdname();
}
