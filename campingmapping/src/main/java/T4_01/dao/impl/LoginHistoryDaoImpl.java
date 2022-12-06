package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import T4_01.beans.LoginHistory;
import T4_01.dao.LoginHistoryDao;
import utils.DbUtils;

public class LoginHistoryDaoImpl implements LoginHistoryDao{

	private QueryRunner queryRunner = new QueryRunner();
	@Override
	public LoginHistory insert(LoginHistory loginHistory) {
try {
	LoginHistory insert = queryRunner.insert(DbUtils.getConnection(), "",new BeanHandler<LoginHistory>(LoginHistory.class));
	return insert;
} catch (SQLException e) {
	e.printStackTrace();
	return null;
}
	}

	@Override
	public int delete(int UID, Date LoginDate) {
		return 0;
	}

	@Override
	public int update(int UID, Date LoginDate) {
		return 0;
	}

	@Override
	public List<LoginHistory> select(int UID) {
		return null;
	}

	@Override
	public List<LoginHistory> selectAll() {
		return null;
	}

}
