package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import T4_01.beans.Limits;
import T4_01.dao.LimitsDao;
import utils.DbUtils;

public class LimitsDaoImpl implements LimitsDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public Limits insert(Limits limits) {
		try {
			Limits insert = queryRunner.insert(DbUtils.getConnection(),
					"INSERT INTO limits (UID,account,nomore,buy,sell,publisher,message,enterprise,applier,mainhoster,attender,campingowner,customer)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new BeanHandler<Limits>(Limits.class), limits.getUID(),
					limits.getAccount(), limits.getNomore(), limits.getBuy(),
					limits.getSell(), limits.getPublisher(),
					limits.getMessage(), limits.getEnterprise(),
					limits.getApplier(), limits.getMainhoster(),
					limits.getAttender(), limits.getCampingowner(),
					limits.getCustomer(), limits.getCampingowner());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(String account) {
		try {
			int update = queryRunner.update(DbUtils.getConnection(), 
					"DELETE FROM limints WHERE account = ?"
					,account);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Limits limits) {
		
		return 0;
	}

	@Override
	public Limits select(String account) {
		return null;
	}

	@Override
	public List<Limits> selectAll() {
		return null;
	}

}
