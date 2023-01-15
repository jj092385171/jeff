package com.campingmapping.team4.spring.t436mall.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//商品列表
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@Component
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pdid")
	private Integer pdid;
	// 產品編號(pk)
	// @Column(name = "userid")
	// private Integer userid;
	@ManyToOne
	@JoinColumn(name = "userid")
//	@JsonIgnore
	private UserProfiles userprofiles;// 會員
	// 會員 ID
	@Column(name = "pdname")
	private String pdname;
	// 產品名稱
	@Column(name = "pdtitle")
	private String pdtitle;
	// 品牌名稱
	@Column(name = "pdcontent")
	private String pdcontent;
	// 產品規格
	@Column(name = "pdtype")
	private String pdtype;
	// 產品類型
	@Column(name = "pdpicture")
	private String pdpicture;
	// 照片 vinbinary
	@Column(name = "pdprice")
	private Integer pdprice;
	// 價位
	@Column(name = "pdinventory")
	private Integer pdinventory;
	// 庫存數量
	@Column(name = "pddate")
	private Date pddate;
	// 商品建立日期
	@Column(name = "pdlastupdate")
	private Date pdlastupdate;
	// 商品更新日期

	@JsonIgnore
	@JsonIgnoreProperties("category")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Builder.Default
	private Set<ProductCart> productcart = new LinkedHashSet<ProductCart>();
	@JsonIgnore
	@JsonIgnoreProperties("category")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@Builder.Default
	private Set<ProductOrderDetail> productorderdetail = new LinkedHashSet<ProductOrderDetail>();
}
