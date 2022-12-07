package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_01.beans.LoginHistory;
import T4_01.dao.LoginHistoryDao;
import utils.DbUtils;

public class LoginHistoryDaoImpl implements LoginHistoryDao {

	private QueryRunner queryRunner = new QueryRunner();
	@Override
	public int insert(LoginHistory loginHistory) {
		try {
			int insert = queryRunner.update(DbUtils.getConnection(),
					"INSERT INTO LoginHistory (UID ,account ,IP ) VALUES (? ,? ,? )",
					loginHistory.getUID(), loginHistory.getAccount(),
					loginHistory.getIP());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
		try {
			List<LoginHistory> query = queryRunner.query(
					DbUtils.getConnection(),
					"SELECT * FROM LoginHistory WHERE UID = ?",
					new BeanListHandler<LoginHistory>(LoginHistory.class), UID);
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LoginHistory> selectAll() {
		try {
			List<LoginHistory> query = queryRunner.query(
					DbUtils.getConnection(), "SELECT * FROM LoginHistory",
					new BeanListHandler<LoginHistory>(LoginHistory.class));
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
