package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer pkey;
	String memberId;
	String name;
	String password;
	String address;
	String email;
	String tel;
	String userType;
	Timestamp registerTime;
	Double totalAmt;
	Blob memberImage;
	String fileName;
	String mimeType;
	Clob comment;
	Double unpaid_amount;

	public MemberBean(Integer pkey, String memberId, String name, String password, String address, String email,
			String tel, String userType, Timestamp registerTime, Double totalAmt, Double unpaid_amount,
			Blob memberImage, String fileName, String mimeType) {
		this.pkey = pkey;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.userType = userType;
		this.registerTime = registerTime;
		this.totalAmt = totalAmt;
		this.unpaid_amount = unpaid_amount;
		this.fileName = fileName;
		this.memberImage = memberImage;
		this.mimeType = mimeType;
	}


	public MemberBean() {
	}

	public Integer getPkey() {
		return pkey;
	}
	
	public void setPkey(int pKey) {
		this.pkey = pKey;
	}

	public Blob getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}

	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setTs(Timestamp ts) {
		this.registerTime = ts;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserType() {
		return userType;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public Double getUnpaid_amount() {
		return unpaid_amount;
	}

	public void setUnpaid_amount(Double unpaid_amount) {
		this.unpaid_amount = unpaid_amount;
	}


	public String getMimeType() {
		return mimeType;
	}


	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}


	public void setPkey(Integer pkey) {
		this.pkey = pkey;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [pkey=");
		builder.append(pkey);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", registerTime=");
		builder.append(registerTime);
		builder.append(", totalAmt=");
		builder.append(totalAmt);
		builder.append(", memberImage=");
		builder.append(memberImage);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", mimeType=");
		builder.append(mimeType);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", unpaid_amount=");
		builder.append(unpaid_amount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
