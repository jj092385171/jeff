package t4_01Member.model.dao;

import java.util.Date;
import java.util.List;

import t4_01Member.model.entity.LoginHistory;


public interface LoginHistoryDao {
	public LoginHistory insert(LoginHistory loginHistory);

	public int delete(int UID, Date LoginDate);

	public int update(int UID, Date LoginDate);

	public List<LoginHistory> select(int UID);

	public List<LoginHistory> selectAll();
	
	public int deleteUID(int uid);
}
