package T4_01.service.impl;

import java.util.List;

import T4_01.beans.Member;
import T4_01.dao.impl.CouponWalletDaoImpl;
import T4_01.dao.impl.LicenseDaoImpl;
import T4_01.dao.impl.LimitsDaoImpl;
import T4_01.dao.impl.LoginHistoryDaoImpl;
import T4_01.dao.impl.MemberImpl;
import T4_01.service.MemberService;
import utils.DbUtils;

public class MemberServiceImpl implements MemberService {

	@Override
	public List<Member> showMember() {
		MemberImpl memberImpl = new MemberImpl();
		List<Member> selectAll = memberImpl.selectAll();
		return selectAll;
	}

	@Override
	public int delte(String account) {
		try {
			DbUtils.commit();
			Member select = new MemberImpl().select(account);
			int uid = select.getUID();
			new LimitsDaoImpl().delete(account);
			new CouponWalletDaoImpl().delete(uid);
			new LicenseDaoImpl().delete(account);
			new LoginHistoryDaoImpl().deleteUID(uid);
			new MemberImpl().delete(account);
			DbUtils.commit();
			return 1;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return 0;
			
		}

	}

}
