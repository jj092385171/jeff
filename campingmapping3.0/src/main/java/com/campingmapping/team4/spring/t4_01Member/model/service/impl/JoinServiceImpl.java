//package com.campingmapping.team4.spring.t4_01Member.model.service.impl;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import T4_01.beans.License;
//import T4_01.beans.Limits;
//import T4_01.beans.Member;
//import T4_01.dao.impl.LicenseDaoImpl;
//import T4_01.dao.impl.LimitsDaoImpl;
//import T4_01.dao.impl.MemberImpl;
//import T4_01.service.JoinService;
//import utils.DbUtils;
//
//public class JoinServiceImpl implements JoinService {
//
//	@Override
//	public Map<String, Object> accountsame(String account) {
//		MemberImpl memberImpl = new MemberImpl();
//		Member select = memberImpl.select(account);
//		HashMap<String, Object> res = new HashMap<>();
//		if (select != null) {
//			res.put("res", 1);
//			return res;
//		} else {
//			res.put("res", 0);
//			return res;
//
//		}
//
//	}
//
//	@Override
//	public int joinNewMember(String account, String password, String email,
//			String birthday) {
//		try {
//			DbUtils.begin();
//			Member member = new Member();
//			License license = new License();
//			Limits limits = new Limits();
//			MemberImpl memberImpl = new MemberImpl();
//			member.setAccount(account);
//			member.setEmail(email);
//			member.setStringBirthday(birthday);;
//			memberImpl.insert(member);
//			int uid = memberImpl.select(account).getUID();
//			license.setUID(uid);
//			license.setAccount(account);
//			license.setPassword(password);
//			new LicenseDaoImpl().insert(license);
//			limits.setUID(uid);
//			limits.setAccount(account);
//			new LimitsDaoImpl().insert(limits);
//			DbUtils.commit();
//			return 1;
//		} catch (Exception e) {
//			DbUtils.rollbacl();
//			e.printStackTrace();
//			return 0;
//		}
//
//	}
//
//}
