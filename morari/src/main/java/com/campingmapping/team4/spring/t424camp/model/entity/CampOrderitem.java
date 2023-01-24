package com.campingmapping.team4.spring.t424camp.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "camporderitem")
@Component
public class CampOrderitem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDERITEMID")
	private Integer orderitemID;
	
	@ManyToOne
	@JoinColumn(name = "FKORDERID")
	private CampOrder campOrder;
	
	@ManyToOne
	@JoinColumn(name = "FKSITEID")
	private Site site;
	
	@Column(name = "FKUSERID")
	private Integer userID;
	
	@Column(name = "ORDERTIME")
	private Date orderTime;
	
	@Column(name = "GOINGTIME")
	private Date goingTime;
	
	@Column(name = "LEAVINGTIME")
	private Date leavingTime;
	
	@Column(name = "NUMBERS")
	private Integer numbers;
	
	@Column(name = "UNITPRICE")
	private Integer unitPrice;

	
	public CampOrderitem() {
		super();
	}

	

	
}
