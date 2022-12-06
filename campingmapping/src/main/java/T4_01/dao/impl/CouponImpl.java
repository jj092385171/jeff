package T4_01.dao.impl;

import java.util.List;

import T4_01.beans.Coupon;
import T4_01.dao.CouponDao;

public class CouponImpl implements CouponDao {

	@Override
	public Coupon insert(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int couponID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Coupon coupon) {
		// UPDATE coupon SET couponCode = ?, couponName = ?, couponType = ?, couponAmount = ?, couponUsed = ?, couponRule = ?, startDate = ?, endDate = ? WHERE ?
		return 0;
	}

	@Override
	public Coupon select(int couponID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
