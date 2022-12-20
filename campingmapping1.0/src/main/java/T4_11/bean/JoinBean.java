package T4_11.bean;

public class JoinBean {
	
	private int joinlistnum;
	private int initiating_num;
	private int joinmember;
	private int joinpeoplenum;
	private int accept;
	
	public JoinBean() {
		
	}
	public int getJoinlistnum() {
		return joinlistnum;
	}
	public void setJoinlistnum(int joinlistnum) {
		this.joinlistnum = joinlistnum;
	}
	public int getInitiating_num() {
		return initiating_num;
	}
	public void setInitiating_num(int initiating_num) {
		this.initiating_num = initiating_num;
	}
	public int getJoinmember() {
		return joinmember;
	}
	public void setJoinmember(int joinmember) {
		this.joinmember = joinmember;
	}
	public int getJoinpeoplenum() {
		return joinpeoplenum;
	}
	public void setJoinpeoplenum(int joinpeoplenum) {
		this.joinpeoplenum = joinpeoplenum;
	}
	public int getAccept() {
		return accept;
	}
	public void setAccept(int accept) {
		this.accept = accept;
	}
	@Override
	public String toString() {
		return "JoinBean [joinlistnum=" + joinlistnum + ", initiating_num=" + initiating_num + ", joinmember="
				+ joinmember + ", joinpeoplenum=" + joinpeoplenum + ", accept=" + accept + "]";
	}
	
}
