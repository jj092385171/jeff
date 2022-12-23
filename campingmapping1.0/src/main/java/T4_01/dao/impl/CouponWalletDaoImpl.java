package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_01.beans.CouponWallet;
import T4_01.dao.CouponWalletDao;
import utils.DbUtils;

public class CouponWalletDaoImpl implements CouponWalletDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public CouponWallet insert(CouponWallet couponWallet) {
		try {
			CouponWallet insert = queryRunner.insert(DbUtils.getConnection(),
					"INSERT INTO couponWallet ( UID , couponID , state ) VALUES ( ? , ? , ? )",
					new BeanHandler<CouponWallet>(CouponWallet.class),
					couponWallet.getUID(), couponWallet.getCouponID(),
					couponWallet.getState());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int delete(int CWID) {
		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"DELETE FROM couponWallet WHERE CWID = ?", CWID);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int update(CouponWallet couponWallet) {
		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"UPDATE couponWallet SET UID = ? , couponID = ? , state = ? WHERE CWID = ?",
					couponWallet.getUID(), couponWallet.getCouponID(),
					couponWallet.getState(), couponWallet.getCWID());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public CouponWallet select(int CWID) {
		try {
			CouponWallet query = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM couponWallet where CWID = ?",
					new BeanHandler<CouponWallet>(CouponWallet.class), CWID);
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public List<CouponWallet> selectAll() {
		List<CouponWallet> query;
		try {
			query = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM couponWallet",
					new BeanListHandler<CouponWallet>(CouponWallet.class));
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
