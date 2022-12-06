package T4_01.dao.impl;

import java.util.Date;
import java.util.List;

import T4_01.beans.LoginHistory;

public interface LoginHistoryDao {
	public LoginHistory insert(LoginHistory loginHistory);

	public int delete(int UID, Date LoginDate);

	public int update(int UID, Date LoginDate);

	public List<LoginHistory> select(int UID);

	public List<LoginHistory> selectAll();
}
