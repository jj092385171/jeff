package com.campingmapping.team4.spring.t409work.model.entity;


import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "resume")
public class ResumeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "number")
	private Integer number;// 履歷編號

	@ManyToOne
	@JoinColumn(name = "uid")
	private UserProfiles userprofiles;// 會員
	
	@ManyToOne
	@JoinColumn(name = "rackid")
	private JobBean job;// 刊登編號

	@Column(name = "work")
	private String work;// 職缺
	@Column(name = "name")
	private String name;// 姓名
	@Column(name = "age")
	private Integer age;// 年次
	@Column(name = "gender")
	private String gender;// 性別
	@Column(name = "mail")
	private String mail;// 電子郵件
	@Column(name = "phone")
	private String phone;// 電話
	@Column(name = "educational")
	private String educational;// 學歷
	@Column(name = "experience")
	private String experience;// 經驗
	@Column(name = "ptime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date ptime;// 時間

}
