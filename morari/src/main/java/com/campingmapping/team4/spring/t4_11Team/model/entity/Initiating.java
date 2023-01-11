package com.campingmapping.team4.spring.t4_11Team.model.entity;

import java.util.Date;

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
@Table(name = "initiating")
public class Initiating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "initiatingnum")
	private int initiatingnum;

	@Column(name = "postmember")
	private int postmember;

	@Column(name = "postdate")
	private Date postdate;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	@Column(name = "currentnum")
	private int currentnum;

	@Column(name = "acceptablenum")
	private int acceptablenum;

	@Column(name = "camparea")
	private String camparea;

	@Column(name = "pair")
	private int pair;

}
