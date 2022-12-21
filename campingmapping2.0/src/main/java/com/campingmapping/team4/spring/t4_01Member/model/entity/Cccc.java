package com.campingmapping.team4.spring.t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cccc")
public class Cccc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aaaa")
private int aaaa;
	
	@Column(name = "bbbb")
	private String bbbb;
	

	public Cccc() {
		super();
	}

	public int getAaaa() {
		return aaaa;
	}

	public void setAaaa(int aaaa) {
		this.aaaa = aaaa;
	}

	public String getBbbb() {
		return bbbb;
	}

	public void setBbbb(String bbbb) {
		this.bbbb = bbbb;
	}

	public Cccc(int aaaa, String bbbb) {
		super();
		this.aaaa = aaaa;
		this.bbbb = bbbb;
	}

	@Override
	public String toString() {
		return String.format("cccc [aaaa=%s, bbbb=%s]", aaaa, bbbb);
	}
}
