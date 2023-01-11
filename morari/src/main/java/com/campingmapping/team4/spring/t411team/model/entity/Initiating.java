package com.campingmapping.team4.spring.t411team.model.entity;

import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

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
@Table(name = "initiating")
public class Initiating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "initiatingnum")
	private Integer initiatingnum;

	@ManyToOne
	@JoinColumn(name = "uid")
	private UserProfiles userprofiles;

	@Column(name = "postdate")
	private Date postdate;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	@Column(name = "currentnum")
	private Integer currentnum;

	@Column(name = "acceptablenum")
	private Integer acceptablenum;

	@Column(name = "camparea")
	private String camparea;

	@Column(name = "pair")
	private Integer pair;

}
