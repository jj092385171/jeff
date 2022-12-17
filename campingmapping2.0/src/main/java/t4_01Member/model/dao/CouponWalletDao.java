package t4_01Member.model.dao;

import java.util.List;

import t4_01Member.model.entity.CouponWallet;


public interface CouponWalletDao {
	public CouponWallet insert(CouponWallet couponWallet);

	public int delete(int CWID);

	public int update(CouponWallet couponWallet);

	public CouponWallet select(int CWID);


	public List<CouponWallet> selectAll();
}
