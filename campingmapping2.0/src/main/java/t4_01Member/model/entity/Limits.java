package t4_01Member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// limits
//權限
@Entity
@Table(name = "limits")
public class Limits {
	// uid
	@Id
	@Column(name = "uid")
	private Integer uid;
	// account
	// 帳號
	@Column(name = "account", insertable = false, updatable = false)
	private String account;
	// nomore
	// 一般
	@Column(name = "nomore")
	private String nomore;
	// buy
	// 買家
	@Column(name = "buy")
	private String buy;
	// sell
	// 賣家
	@Column(name = "sell")
	private String sell;
	// publisher
	// 發文
	@Column(name = "publisher")
	private String publisher;
	// message
	// 留言
	@Column(name = "message")
	private String message;
	// enterprise
	// 雇主
	@Column(name = "enterprise")
	private String enterprise;
	// applier
	// 應徵者
	@Column(name = "applier")
	private String applier;
	// mainhoster
	// 揪團主
	@Column(name = "mainhoster")
	private String mainhoster;
	// attender
	// 參加者
	@Column(name = "attender")
	private String attender;
	// campingowner
	// 營主
	@Column(name = "campingowner")
	private String campingowner;
	// customer
	// 營地預定
	@Column(name = "customer")
	private String customer;
	// admin
	@Column(name = "admin")
	private String admin;
	// member
	@Column(name = "members")
	private String members;
	// show
	@Column(name = "show")
	private String show;
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_account] FOREIGN KEY([account])
	// REFERENCES [dbo].[member] ([account])
	// ALTER TABLE [dbo].[limits] WITH CHECK ADD CONSTRAINT
	// [fk_member_limits_uid] FOREIGN KEY([uid])
	// REFERENCES [dbo].[member] ([uid])
	// @JoinColumn(name = "fk_member_limits_account")
	@OneToOne
	@MapsId
	@JoinColumn(name = "uid")
	private Member member;
	
	@OneToOne
	@JoinColumn(name = "account")
	private Member memberA;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNomore() {
		return nomore;
	}

	public void setNomore(String nomore) {
		this.nomore = nomore;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getApplier() {
		return applier;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	public String getMainhoster() {
		return mainhoster;
	}

	public void setMainhoster(String mainhoster) {
		this.mainhoster = mainhoster;
	}

	public String getAttender() {
		return attender;
	}

	public void setAttender(String attender) {
		this.attender = attender;
	}

	public String getCampingowner() {
		return campingowner;
	}

	public void setCampingowner(String campingowner) {
		this.campingowner = campingowner;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
