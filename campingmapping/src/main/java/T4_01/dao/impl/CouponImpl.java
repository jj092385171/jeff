package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_01.beans.Coupon;
import T4_01.dao.CouponDao;
import utils.DbUtils;

public class CouponImpl implements CouponDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public int insert(Coupon coupon) {
		try {
			int insert = queryRunner.update(DbUtils.getConnection(),
					"UPDATE coupon SET couponCode = ?, couponName = ?, couponType = ?, couponAmount = ?, couponUsed = ?, couponRule = ?, startDate = ?, endDate = ? WHERE couponID = ?",
					 coupon.getCouponID(),
					coupon.getCouponCode(), coupon.getCouponName(),
					coupon.getCouponType(), coupon.getCouponAmount(),
					coupon.getCouponUsed(), coupon.getCouponRule(),
					coupon.getStartDate(), coupon.getEndDate());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int delete(int couponID) {
		try {
			int delete = queryRunner.update(DbUtils.getConnection(),
					"DELETE FROM limints WHERE account = ?", couponID);
			return delete;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Coupon coupon) {

		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"UPDATE coupon SET couponCode = ?, couponName = ?, couponType = ?, couponAmount = ?, couponUsed = ?, couponRule = ?, startDate = ?, endDate = ? WHERE couponID = ?",
					coupon.getCouponCode(), coupon.getCouponName(),
					coupon.getCouponType(), coupon.getCouponAmount(),
					coupon.getCouponUsed(), coupon.getCouponRule(),
					coupon.getStartDate(), coupon.getEndDate(),
					coupon.getCouponID());

			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Coupon select(int couponID) {
		try {
			Coupon coupon = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM limits WHERE couponID =?",
					new BeanHandler<Coupon>(Coupon.class), couponID);
			return coupon;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Coupon> selectAll() {
		try {
			List<Coupon> couponsList = queryRunner.query(
					DbUtils.getConnection(), "SELECT * FROM limits ",
					new BeanListHandler<Coupon>(Coupon.class));
			return couponsList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
