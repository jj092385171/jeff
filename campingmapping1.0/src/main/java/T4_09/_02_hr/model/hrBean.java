package T4_09._02_hr.model;

public class hrBean {

	private int uID;//會員
	private String name;//姓名
	private String l_experience;//學歷
	private String seniority;//年資
	private String language;//語言
	private String apply;//應徵類別
	private String remark;//備註

	public hrBean(){
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("hrBean [uID=");
		builder.append(uID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", l_experience=");
		builder.append(l_experience);
		builder.append(", seniority=");
		builder.append(seniority);
		builder.append(", language=");
		builder.append(language);
		builder.append(", apply=");
		builder.append(apply);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getL_experience() {
		return l_experience;
	}

	public void setL_experience(String l_experience) {
		this.l_experience = l_experience;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getApply() {
		return apply;
	}


	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public hrBean(int uID, String name, String l_experience, String seniority, String language, String apply,
			String remark) {
		super();
		this.uID = uID;
		this.name = name;
		this.l_experience = l_experience;
		this.seniority = seniority;
		this.language = language;
		this.apply = apply;
		this.remark = remark;
	}

	

	
}
