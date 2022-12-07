package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_01.beans.Limits;
import T4_01.dao.LimitsDao;
import utils.DbUtils;

public class LimitsDaoImpl implements LimitsDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public int insert(Limits limits) {
		try {
			int insert = queryRunner.update(DbUtils.getConnection(),
					"INSERT INTO limits (UID,account,nomore,buy,sell,publisher,message,enterprise,applier,mainhoster,attender,campingowner,customer)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
					limits.getSell(), limits.getPublisher(),
					limits.getMessage(), limits.getEnterprise(),
					limits.getApplier(), limits.getMainhoster(),
					limits.getAttender(), limits.getCampingowner(),
					limits.getCustomer(), limits.getCampingowner());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String account) {
		try {
			int delete = queryRunner.update(DbUtils.getConnection(),
					"DELETE FROM limints WHERE account = ?", account);
			return delete;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Limits limits) {

		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"UPDATE limits SET   account = ? , nomore = ? , buy = ? , sell = ? , publisher = ? , message = ? , enterprise = ? , applier = ? , mainhoster = ? , attender = ? , campingowner = ? , customer = ? WHERE UID = ?",
					limits.getAccount(), limits.getNomore(), limits.getBuy(),
					limits.getSell(), limits.getPublisher(),
					limits.getMessage(), limits.getEnterprise(),
					limits.getApplier(), limits.getMainhoster(),
					limits.getAttender(), limits.getCampingowner(),
					limits.getCustomer(), limits.getCampingowner(),
					limits.getUID());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public Limits select(String account) {
		try {
			Limits limits = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM limits WHERE account =?",
					new BeanHandler<Limits>(Limits.class),account);
			return limits;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Limits> selectAll() {
		try {
			List<Limits> limitslist = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM limits WHERE",
					new BeanListHandler<Limits>(Limits.class));
			return limitslist;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
