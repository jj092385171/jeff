package t4_01Member.model.dao;

import java.util.List;

import t4_01Member.model.entity.Coupon;



public interface CouponDao {
	public Coupon insert(Coupon coupon);

	public int delete(int couponID);

	public int update(Coupon coupon);

	public Coupon select(int couponID);

	public List<Coupon> selectAll();
}
