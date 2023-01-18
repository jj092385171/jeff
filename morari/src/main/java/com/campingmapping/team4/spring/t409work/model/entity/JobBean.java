package com.campingmapping.team4.spring.t409work.model.entity;

import java.sql.Blob;
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
@Table(name = "job")
public class JobBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rackid")
	private Integer rackid;// 刊登編號

	@ManyToOne
//	@JsonIgnore
	@JoinColumn(name = "uid")
	private UserProfiles userprofiles;// 會員
	
//	@Column(name="uid")
//	@Transient
//	private Integer uid;

	@Column(name = "job")
	private String job;// 職缺
	@Column(name = "salary")
	private String salary;// 薪資
	@Column(name = "quantity")
	private Integer quantity;// 人數
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
	@Column(name = "rackup")
	private Date rackup;// 上架日期

}