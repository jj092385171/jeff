package T4_11.servletProject.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_11.bean.InitiatingBean;
import T4_11.bean.JoinBean;
import T4_11.bean.MessagelistBean;
import utils.DbUtils;

public class InitiatingDaoImpl implements InitiatingDao{

	private QueryRunner queryRunner = new QueryRunner();
	
	@Override
	public String sqlCommand(String startdate, String enddate, String initiatingnum, String postmember,String camparea) {
		String sql = "";
		String numCommand = "";
		String memberCommand = "";
		String areaCommand = "";
		String stdCommand = "";
		String edCommand = "";
		
		if(!initiatingnum.equals("0")) {
			numCommand = numCommand + "initiatingnum = " + initiatingnum + " AND ";
		}else {
			if(!postmember.equals("0")) {
				memberCommand = memberCommand + "postmember = " + postmember + " AND ";
			}
			if(!camparea.equals("0")) {
				areaCommand = areaCommand + "camparea = " + "'" + camparea + "'" + " AND ";
			}
			if(startdate.length()>1) {
				stdCommand = stdCommand + "startdate >= " + "'" + startdate + "'" + " AND ";
			}
			if(enddate.length()>1) {
				edCommand = edCommand + "enddate <=" + "'" + enddate + "'" +" AND ";
			}
		}
		
		sql = sql + "SELECT * FROM initiating WHERE " + numCommand + memberCommand + areaCommand + stdCommand + edCommand;
		
		String sqlCommand = sql.substring(0,sql.length()-4);
		System.out.println(sqlCommand);
		return sqlCommand;
	}
	
	@Override
	public int insertInitiating(InitiatingBean initiatingBean) {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO initiating (postmember,startdate,enddate,currentnum,acceptablenum,camparea,pair) values(?,?,?,?,?,?,?)";
		try {
			Object[] params = {initiatingBean.getPostmember(),initiatingBean.getStartdate(),initiatingBean.getEnddate(),
					initiatingBean.getCurrentnum(),initiatingBean.getAcceptablenum(),initiatingBean.getCamparea(),initiatingBean.getPair()};
			int row = qr.update(DbUtils.getConnection(), sql , params);
			//System.out.println("新增了" + row + "筆資料");
			return row;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteInitiating(int initiatingnum) {
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM initiating WHERE initiatingnum =?";
		try {
			int row = qr.update(DbUtils.getConnection(), sql, initiatingnum);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateInitiating(InitiatingBean initiatingBean) {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE initiating SET startdate=?,enddate=?,currentnum=?,acceptablenum=?,camparea=?,pair=? WHERE initiatingnum=?";
		Object[] params = {initiatingBean.getStartdate(),initiatingBean.getEnddate(),initiatingBean.getCurrentnum(),
				initiatingBean.getAcceptablenum(),initiatingBean.getCamparea(),initiatingBean.getPair(),initiatingBean.getInitiatingnum()};
		try {
			int row = qr.update(DbUtils.getConnection(), sql, params);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<InitiatingBean> selectInitiating(String sql) {
		
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<InitiatingBean>(InitiatingBean.class));
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<InitiatingBean> selectMember(InitiatingBean initiatingBean) {
		String sql = "SELECT * FROM initiating WHERE postmember = ?";
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<InitiatingBean>(InitiatingBean.class), initiatingBean.getPostmember());
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InitiatingBean> selectCamparea(InitiatingBean initiatingBean) {
		String sql = "SELECT * FROM initiating WHERE camparea = ?";
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<InitiatingBean>(InitiatingBean.class), initiatingBean.getCamparea());
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List<InitiatingBean> selectMemberAndCamparea(InitiatingBean initiatingBean) {
		String sql = "SELECT * FROM initiating WHERE postmember = ? AND camparea = ?";
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<InitiatingBean>(InitiatingBean.class), initiatingBean.getPostmember(),initiatingBean.getCamparea());
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List<InitiatingBean> selectAllInitiating() {
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(), "SELECT * FROM  Initiating",new BeanListHandler<InitiatingBean>(InitiatingBean.class));
			
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<InitiatingBean> selectAllCamparea() {
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(), "SELECT DISTINCT camparea FROM  Initiating",new BeanListHandler<InitiatingBean>(InitiatingBean.class));
		
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<InitiatingBean> selectAllMember() {
		try {
			List<InitiatingBean> InitiatingBean = queryRunner.query(DbUtils.getConnection(), "SELECT DISTINCT postmember FROM  Initiating",new BeanListHandler<InitiatingBean>(InitiatingBean.class));
			return InitiatingBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insertJoin(JoinBean joinBean) {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO joinlist(initiating_num,joinmember,joinpeoplenum,accept) VALUES(?,?,?,?)";
		Object[] params = {joinBean.getInitiating_num(),joinBean.getJoinmember(),joinBean.getJoinpeoplenum(),joinBean.getAccept()};
		try {
			int row = qr.update(DbUtils.getConnection(), sql, params);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteJoin(int joinlistnum) {
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM joinlist WHERE joinlistnum=?";
		try {
			int row = qr.update(DbUtils.getConnection(), sql, joinlistnum);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateJoin(JoinBean joinBean) {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE joinlist SET joinpeoplenum=?,accept=? WHERE joinlistnum = ?";
		Object[] params = {joinBean.getJoinpeoplenum(),joinBean.getAccept(),joinBean.getJoinlistnum()};
		try {
			int row = qr.update(DbUtils.getConnection(), sql, params);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public JoinBean selectJoin(int joinlistnum) {
		
		return null;
	}

	@Override
	public List<JoinBean> selectAllJoinlist() {
		try {
			List<JoinBean> JoinBean = queryRunner.query(DbUtils.getConnection(), "SELECT * FROM  joinlist",new BeanListHandler<JoinBean>(JoinBean.class));
			return JoinBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMessage(MessagelistBean messagelistBean) {
		return 0;
	}

	@Override
	public int deleteMessage(int messagelistnum) {
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM messagelis WHERE messagelistnum=?";
		try {
			int row = qr.update(DbUtils.getConnection(), sql, messagelistnum);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMessage(MessagelistBean messagelistBean) {
		return 0;
	}

	@Override
	public MessagelistBean selectMessage(int messagelistnum) {
		return null;
	}

	@Override
	public List<MessagelistBean> selectAllMessage() {
		return null;
	}

	@Override
	public InitiatingBean setInitiatingBean(Map<String,String[]> map) {
		InitiatingBean initiatingBean = new InitiatingBean();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			String[] val = entry.getValue();
			String result = val[0];
			switch (key) {
			case "initiatingnum":
				initiatingBean.setInitiatingnum(Integer.valueOf(result));
				break;
			case "postmember":
				initiatingBean.setPostmember(Integer.valueOf(result));
				break;
			case "startdate":
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				try {
					initiatingBean.setStartdate(sd.parse(result));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "enddate":
				SimpleDateFormat ed = new SimpleDateFormat("yyyy-MM-dd");
				try {
					initiatingBean.setEnddate(ed.parse(result));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "currentnum":
				initiatingBean.setCurrentnum(Integer.valueOf(result));
				break;
			case "acceptnum":
				initiatingBean.setAcceptablenum(Integer.valueOf(result));
				break;
			case "camparea":
				initiatingBean.setCamparea(result);
				break;
			case "pair":
				initiatingBean.setPair(Integer.valueOf(result));
				break;
			}
		}
		return initiatingBean;
	}

}