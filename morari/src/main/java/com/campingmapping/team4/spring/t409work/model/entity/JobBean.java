package com.campingmapping.team4.spring.t409work.model.entity;

import java.util.Collection;
import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = {"resume"})
@Entity
@Table(name = "job")
public class JobBean {
//	@JsonIgnoreProperties("job")
	@OneToMany(fetch = FetchType.LAZY,mappedBy="job")//設一個外來建的集合
	@JsonIgnore
	private Collection<ResumeBean> resume;

	@ManyToOne
	@JoinColumn(name = "uid")
	private UserProfiles userprofiles;// 會員
	
//	@ManyToOne
//	@JoinColumn(name = "camp") // 營區地點、照片
//	private Camp camp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rackid")
	private Integer rackid;// 刊登編號
	
	@Column(name = "campname")
	private String campname;// 營地名稱
	@Column(name = "place")
	private String place;// 地點
	@Column(name = "job")
	private String job;// 職缺
	@Column(name = "salary")
	private String salary;// 薪資
	@Column(name = "quantity")
	private Integer quantity;// 人數
	@Column(name = "date")
	private String date;// 上班日期
	@Column(name = "time")
	private String time;// 上班時段
	@Column(name = "remark")
	private String remark;// 備註
	@Column(name = "rackup")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date rackup;// 上架日期
	@Column(name = "img")
	private String img;// 照片

}