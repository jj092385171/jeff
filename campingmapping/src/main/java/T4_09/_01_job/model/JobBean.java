package T4_09._01_job.model;

import java.sql.Blob;
import java.util.Date;

public class JobBean {

	private int uID;//會員
	private String blank;//職缺
	private int salary;//薪資
	private int quantity;//人數
	private String place;//地點
	private String date;//上班日期
	private String time;//上班時段
	private Blob img;//上班時段
	private String remark;//備註
	private Date rackUp;//上架日期
	private Date rackDown;//下架日期
	
	public JobBean(){
	}
	
	public JobBean(int uID, String blank, int salary, int quantity, String place, String date, String time, Blob img,
			String remark, Date rackUp, Date rackDown) {
		super();
		this.uID = uID;
		this.blank = blank;
		this.salary = salary;
		this.quantity = quantity;
		this.place = place;
		this.date = date;
		this.time = time;
		this.img = img;
		this.remark = remark;
		this.rackUp = rackUp;
		this.rackDown = rackDown;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	
	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRackUp() {
		return rackUp;
	}

	public void setRackUp(Date rackUp) {
		this.rackUp = rackUp;
	}

	public Date getRackDown() {
		return rackDown;
	}

	public void setRackDown(Date rackDown) {
		this.rackDown = rackDown;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobBean [uID=");
		builder.append(uID);
		builder.append(", blank=");
		builder.append(blank);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", place=");
		builder.append(place);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time=");
		builder.append(time);
		builder.append(", img=");
		builder.append(img);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", rackUp=");
		builder.append(rackUp);
		builder.append(", rackDown=");
		builder.append(rackDown);
		builder.append("]");
		return builder.toString();
	}



	

	
	
}
