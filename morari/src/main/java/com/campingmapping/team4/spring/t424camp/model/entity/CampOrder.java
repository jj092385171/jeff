package com.campingmapping.team4.spring.t424camp.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "camporder")
@Component
public class CampOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDERID")
	private Integer orderID;
	
	@Column(name = "USERID")
	private Integer userID;
	
	@Column(name = "ORDERTIME")
	private Date orderTime;
	
	@Column(name = "GOINGTIME")
	private Date goingTime;
	
	@Column(name = "LEAVINGTIME")
	private Date leavingTime;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "TOTALPRICE")
	private Integer totalPrice;
	
	@Column(name = "FKCAMPID")
	private Integer campID;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "campOrder")
	private Set<CampOrderitem> orderitems = new HashSet<CampOrderitem>();

	
	public CampOrder() {
		super();
	}

	public CampOrder(Integer orderID, Integer userID, Date orderTime, Date goingTime, Date leavingTime, String status,
			Integer totalPrice, Integer campID) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.orderTime = orderTime;
		this.goingTime = goingTime;
		this.leavingTime = leavingTime;
		this.status = status;
		this.totalPrice = totalPrice;
		this.campID = campID;
	}

	
	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getGoingTime() {
		return goingTime;
	}

	public void setGoingTime(Date goingTime) {
		this.goingTime = goingTime;
	}

	public Date getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(Date leavingTime) {
		this.leavingTime = leavingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getCampID() {
		return campID;
	}

	public void setCampID(Integer campID) {
		this.campID = campID;
	}


}
