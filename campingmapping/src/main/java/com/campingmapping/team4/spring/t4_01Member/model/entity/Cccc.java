package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cccc")
public class Cccc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aaaa")
private Integer aaaa;
	
	@Column(name = "bbbb")
	private String bbbb;
	


}
