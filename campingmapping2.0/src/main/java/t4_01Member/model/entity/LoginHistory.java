package t4_01Member.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// loginhistory
//登入歷史
@Entity
@Table(name = "loginhistory")
public class LoginHistory {
	
	
	// lhid 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lhid")
	private int lhid; 
	//uid
	@Column(name = "uid")
	private int uid;
	// account 
	//帳號
	@Column(name = "account")
	private String account;
	// ip 
	//IP位置
	@Column(name = "ip")
	private String ip;
	// logindate 
	//登入時間
	@Column(name = "logindate")
	private Date logindate;
	// show 
	@Column(name = "show")
	private String show;
	// ALTER TABLE [dbo].[loginhistory]  WITH CHECK ADD  CONSTRAINT [fk_member_loginhistory_account] FOREIGN KEY([account])
	// REFERENCES [dbo].[member] ([account])
	// ALTER TABLE [dbo].[loginhistory]  WITH CHECK ADD  CONSTRAINT [fk_member_loginhistory_uid] FOREIGN KEY([UID])
	// REFERENCES [dbo].[member] ([uid])
	@ManyToOne
	@JoinColumn(name = "fk_member_loginhistory_account")
	@JoinColumn(name = "fk_member_loginhistory_uid")
	private Member member;

	public LoginHistory() {
	}

	public LoginHistory(int lhid, int uid, String account, String ip,
			Date logindate, String show, Member member) {
		super();
		this.lhid = lhid;
		this.uid = uid;
		this.account = account;
		this.ip = ip;
		this.logindate = logindate;
		this.show = show;
		this.member = member;
	}

	public int getLhid() {
		return lhid;
	}

	public void setLhid(int lhid) {
		this.lhid = lhid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLogindate() {
		return logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
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

	@Override
	public String toString() {
		return String.format(
				"LoginHistory [lhid=%s, uid=%s, account=%s, ip=%s, logindate=%s, show=%s, member=%s]",
				lhid, uid, account, ip, logindate, show, member);
	}
	
	

	
}
