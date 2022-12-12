package T4_11.servletProject.dao;

import java.util.List;
import java.util.Map;

import T4_11.bean.InitiatingBean;
import T4_11.bean.JoinBean;
import T4_11.bean.MessagelistBean;

public interface InitiatingDao {
	
	public String sqlCommand(String startdate, String enddate, String initiatingnum, String postmember, String camparea);
	
	public InitiatingBean setInitiatingBean(Map<String,String[]> initiatingBean);
	
	public int insertInitiating(InitiatingBean initiatingBean);
	
	public int deleteInitiating(int initiatingnum);
	
	public int updateInitiating(InitiatingBean initiatingnum);
	
	public List<InitiatingBean> selectInitiating(String sql);
	
	public List<InitiatingBean> selectMember(InitiatingBean initiatingBean);
	
	public List<InitiatingBean> selectCamparea(InitiatingBean initiatingBean);
	
	public List<InitiatingBean> selectMemberAndCamparea(InitiatingBean initiatingBean);

	public List<InitiatingBean> selectAllInitiating();
	
	public List<InitiatingBean> selectAllCamparea();
	
	public List<InitiatingBean> selectAllMember();
	
	public int insertJoin(JoinBean joinBean);
	
	public int deleteJoin(int joinlistnum);
	
	public int updateJoin(JoinBean joinlistnum);
	
	public JoinBean selectJoin(int joinlistnum);
	
	public List<JoinBean> selectAllJoinlist();
	
	public int insertMessage(MessagelistBean messagelistBean);
	
	public int deleteMessage(int messagelistnum);
	
	public int updateMessage(MessagelistBean messagelistBean);
	
	public MessagelistBean selectMessage(int messagelistnum);
	
	public List<MessagelistBean> selectAllMessage();
}
