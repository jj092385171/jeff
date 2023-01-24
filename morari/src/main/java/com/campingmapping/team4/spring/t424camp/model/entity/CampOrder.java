package com.campingmapping.team4.spring.t424camp.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FKUSERID")
	private UserProfiles userprofiles;
	
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
	
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FKCAMPID")
	private Camp camp;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "campOrder")
	private Set<CampOrderitem> orderitems = new HashSet<CampOrderitem>();

	
	public CampOrder() {
		super();
	}

	public CampOrder(Integer orderID, UserProfiles userprofiles, Date orderTime, Date goingTime, Date leavingTime,
			String status, Integer totalPrice, Camp camp) {
		super();
		this.orderID = orderID;
		this.userprofiles = userprofiles;
		this.orderTime = orderTime;
		this.goingTime = goingTime;
		this.leavingTime = leavingTime;
		this.status = status;
		this.totalPrice = totalPrice;
		this.camp = camp;
	}

	
	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public UserProfiles getUserprofiles() {
		return userprofiles;
	}

	public void setUserprofiles(UserProfiles userprofiles) {
		this.userprofiles = userprofiles;
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

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public Set<CampOrderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<CampOrderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
