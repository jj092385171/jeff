package com.campingmapping.team4.spring.t4_09Job.model.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="job")

public class JobBean {
	@Column(name = "uID")
	private int uID;//會員
	@Column(name = "rackID")
	private int rackID;//刊登編號
	@Column(name = "job")
	private String job;//職缺
	@Column(name = "salary")
	private String salary;//薪資
	@Column(name = "quantity")
	private int quantity;//人數
	@Column(name = "place")
	private String place;//地點
	@Column(name = "date")
	private String date;//上班日期
	@Column(name = "time")
	private String time;//上班時段
	@Column(name = "img")
	private Blob img;//圖片
	@Column(name = "remark")
	private String remark;//備註
	@Column(name = "rackUp")
	private Date rackUp;//上架日期
	@Column(name = "rackDown")
	private Date rackDown;//下架日期
	
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public int getRackID() {
		return rackID;
	}
	public void setRackID(int rackID) {
		this.rackID = rackID;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobBean [uID=");
		builder.append(uID);
		builder.append(", rackID=");
		builder.append(rackID);
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
	public JobBean(int uID, int rackID, String job, String salary, int quantity, String place, String date, String time,
			Blob img, String remark, Date rackUp, Date rackDown) {
		super();
		this.uID = uID;
		this.rackID = rackID;
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
	public JobBean() {
	}
	
	
	
}