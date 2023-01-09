package com.campingmapping.team4.spring.t4_01Member.model.entity;

import java.sql.Blob;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//會員
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
	// uid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer uid;
	// account
	// 帳號
	@Column(name = "account")
	private String account;
	// nickname
	// 暱稱
	@Column(name = "nickname")
	private String nickname;
	// firstname
	// 名
	@Column(name = "firstname")
	private String firstname;
	// lastname
	// 姓
	@Column(name = "lastname")
	private String lastname;
	// exp
	// 經驗
	@Column(name = "exp")
	private Integer exp;
	// leavel
	// 等級()
	@Column(name = "leavel")
	private Integer leavel;
	// point
	// 點數
	@Column(name = "point")
	private Integer point;
	// phone
	// 手機
	@Column(name = "phone")
	private String phone;
	// birthday
	// 生日
	@Column(name = "birthday")
	private Date birthday;
	// address
	// 居住地
	@Column(name = "address")
	private String address;
	// email
	// 電子信箱
	@Column(name = "email")
	private String email;
	// gender
	// 性別
	@Column(name = "gender")
	private Integer gender;
	// registerdata
	// 註冊日期
	@Column(name = "registerdata")
	private Date registerdata;
	// subscribed
	// 訂閱(Y y/N n)
	@Column(name = "subscribed")
	private String subscribed;
	// shot
	// 大頭像
	@Column(name = "shot")
	private Blob shot;
	// show
	@Column(name = "show")
	private String show;
	// show
	@Column(name = "about")
	private String about;

	@JsonIgnore
	@JsonIgnoreProperties("member")
	@OneToOne(mappedBy = "member")
	private License license;

	@JsonIgnore
	@JsonIgnoreProperties("member")
	@OneToOne(mappedBy = "member")
	private Limits limits;

	@JsonIgnore
	@JsonIgnoreProperties("member")
	@OneToMany(mappedBy = "member")
	@OrderBy("logindate desc")
	@Builder.Default
	private Set<LoginHistory> loginHistories = new LinkedHashSet<LoginHistory>();

	@JsonIgnore
	@JsonIgnoreProperties("member")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	@OrderBy("cwid desc")
	@Builder.Default
	private Set<CouponWallet> couponWallet = new LinkedHashSet<CouponWallet>();
	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return getAccount();
	}

	@Override
	public String getPassword() {
		return license.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}