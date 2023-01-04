package com.campingmapping.team4.spring.t4_11Team.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public Initiating() {
		
	}
	
	public int getInitiatingnum() {
		return initiatingnum;
	}

	public void setInitiatingnum(int initiatingnum) {
		this.initiatingnum = initiatingnum;
	}

	public int getPostmember() {
		return postmember;
	}

	public void setPostmember(int postmember) {
		this.postmember = postmember;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getCurrentnum() {
		return currentnum;
	}

	public void setCurrentnum(int currentnum) {
		this.currentnum = currentnum;
	}

	public int getAcceptablenum() {
		return acceptablenum;
	}

	public void setAcceptablenum(int acceptablenum) {
		this.acceptablenum = acceptablenum;
	}

	public String getCamparea() {
		return camparea;
	}

	public void setCamparea(String camparea) {
		this.camparea = camparea;
	}

	public int getPair() {
		return pair;
	}

	public void setPair(int pair) {
		this.pair = pair;
	}
	
	public Initiating(int initiatingnum, int postmember, Date postdate, Date startdate, Date enddate,
			int currentnum, int acceptablenum, String camparea, int pair, String startdatestr, String enddatestr) {
		super();
		this.initiatingnum = initiatingnum;
		this.postmember = postmember;
		this.postdate = postdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.currentnum = currentnum;
		this.acceptablenum = acceptablenum;
		this.camparea = camparea;
		this.pair = pair;
	}

	@Override
	public String toString() {
		return "InitiatingBean [initiatingnum=" + initiatingnum + ", postmember=" + postmember + ", postdate="
				+ postdate + ", startdate=" + startdate + ", enddate=" + enddate + ", currentnum=" + currentnum
				+ ", acceptablenum=" + acceptablenum + ", camparea=" + camparea + ", pair=" + pair + "]";
	}
}
