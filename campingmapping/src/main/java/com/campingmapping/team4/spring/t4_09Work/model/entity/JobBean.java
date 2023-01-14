package com.campingmapping.team4.spring.t4_09Work.model.entity;

import java.sql.Blob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")

public class JobBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rackID")
	private int rackID;// 刊登編號
	@Column(name = "uID")
	private int uID;// 會員
	@Column(name = "job")
	private String job;// 職缺
	@Column(name = "salary")
	private String salary;// 薪資
	@Column(name = "quantity")
	private int quantity;// 人數
	@Column(name = "place")
	private String place;// 地點
	@Column(name = "date")
	private String date;// 上班日期
	@Column(name = "time")
	private String time;// 上班時段
	@Column(name = "img")
	private Blob img;// 圖片
	@Column(name = "remark")
	private String remark;// 備註
	@Column(name = "rackUp")
	private Date rackUp;// 上架日期
	@Column(name = "rackDown")
	private Date rackDown;// 下架日期

	public JobBean(int rackID, int uID, String job, String salary, int quantity, String place, String date, String time,
			Blob img, String remark, Date rackUp, Date rackDown) {
		super();
		this.rackID = rackID;
		this.uID = uID;
		this.job = job;
		this.salary = salary;
		this.quantity = quantity;
		this.place = place;
		this.date = date;
		this.time = time;
		this.img = img;
		this.remark = remark;
		this.rackUp = rackUp;
		this.rackDown = rackDown;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobBean [rackID=");
		builder.append(rackID);
		builder.append(", uID=");
		builder.append(uID);
		builder.append(", job=");
		builder.append(job);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", place=");
		builder.append(place);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time=");
		builder.append(time);
		builder.append(", img=");
		builder.append(img);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", rackUp=");
		builder.append(rackUp);
		builder.append(", rackDown=");
		builder.append(rackDown);
		builder.append("]");
		return builder.toString();
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRackUp() {
		return rackUp;
	}

	public void setRackUp(Date rackUp) {
		this.rackUp = rackUp;
	}

	public Date getRackDown() {
		return rackDown;
	}

	public void setRackDown(Date rackDown) {
		this.rackDown = rackDown;
	}

	public int getRackID() {
		return rackID;
	}

	public JobBean() {
	}

}