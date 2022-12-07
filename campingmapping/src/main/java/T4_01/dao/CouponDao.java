package T4_01.dao;

import java.util.List;

import T4_01.beans.Coupon;


public interface CouponDao {
	public int insert(Coupon coupon);

	public int delete(int couponID);

	public int update(Coupon coupon);

	public Coupon select(int couponID);

	public List<Coupon> selectAll();
}
