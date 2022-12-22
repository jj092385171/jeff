//package com.campingmapping.team4.spring.t4_01Member.model.service.impl;
//
//import java.util.List;
//
//import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.MemberDaoImpl;
//import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
//import com.campingmapping.team4.spring.t4_01Member.model.service.MemberService;
//
//
//
//public class MemberServiceImpl implements MemberService {
//
//	@Override
//	public List<Member> showMember() {
//		MemberDaoImpl memberImpl = new MemberDaoImpl();
//		List<Member> selectAll = memberImpl.getAll();
//		return selectAll;
//	}
//
//	@Override
//	public int delte(String account) {
//		try {
//			DbUtils.commit();
//			Member select = new MemberImpl().select(account);
//			int uid = select.getUID();
//			new LimitsDaoImpl().delete(account);
//			new CouponWalletDaoImpl().delete(uid);
//			new LicenseDaoImpl().delete(account);
//			new LoginHistoryDaoImpl().deleteUID(uid);
//			new MemberImpl().delete(account);
//			DbUtils.commit();
//			return 1;
//		} catch (Exception e) {
//			DbUtils.rollbacl();
//			e.printStackTrace();
//			return 0;
//			
//		}
//
//	}
//
//}
