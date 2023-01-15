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
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productorder")
@Component
public class ProductOrder {

	@Id
	@Column(name = "id")
	private Integer id;
	// 訂單編號(自動產生亂碼)(pk)
	// @Column(name = "userid")
	// private Integer userid;
	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonIgnore
	private UserProfiles userprofiles;
	// 會員 ID
	@Column(name = "privateodstatus")
	private String privateodstatus;
	// 訂單狀態
	@Column(name = "datetime")
	private Date datetime;
	// 下訂單日期
	@Column(name = "money")
	private Integer money;
	// 總計
	@Column(name = "odshippingaddress")
	private String odshippingaddress;
	// 運送位置
	@Column(name = "odrecipient")
	private String odrecipient;
	// 收件人名稱
	@Column(name = "odrecipientphone")
	private String odrecipientphone;
	// 收件人電話

	@JsonIgnore
	@JsonIgnoreProperties("productorder")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productorder")
	@Builder.Default
	private Set<ProductOrderDetail> productorderdetail = new LinkedHashSet<ProductOrderDetail>();
}
