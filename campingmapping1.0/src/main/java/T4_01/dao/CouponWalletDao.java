package T4_01.dao;

import java.util.List;

import T4_01.beans.CouponWallet;

public interface CouponWalletDao {
	public CouponWallet insert(CouponWallet couponWallet);

	public int delete(int CWID);

	public int update(CouponWallet couponWallet);

	public CouponWallet select(int CWID);


	public List<CouponWallet> selectAll();
}
