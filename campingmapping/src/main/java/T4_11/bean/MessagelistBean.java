package T4_11.bean;

public class MessagelistBean {
	
	private int messagelistnum;
	private int initiating_num;
	private int messagemember;
	private String messagetext;
	
	public MessagelistBean() {
		
	}

	@Override
	public String toString() {
		return "MessagelistBean [messagelistnum=" + messagelistnum + ", initiating_num=" + initiating_num
				+ ", messagemember=" + messagemember + ", messagetext=" + messagetext + "]";
	}
	
}
