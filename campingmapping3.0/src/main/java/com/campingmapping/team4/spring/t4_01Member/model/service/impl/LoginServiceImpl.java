//package com.campingmapping.team4.spring.t4_01Member.model.service.impl;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import T4_01.beans.License;
//import T4_01.beans.Limits;
//import T4_01.beans.LoginHistory;
//import T4_01.beans.Member;
//import T4_01.dao.LicenseDao;
//import T4_01.dao.impl.LicenseDaoImpl;
//import T4_01.dao.impl.LimitsDaoImpl;
//import T4_01.dao.impl.LoginHistoryDaoImpl;
//import T4_01.dao.impl.MemberImpl;
//import T4_01.service.LoginService;
//import utils.DbUtils;
//
//public class LoginServiceImpl implements LoginService {
//	private LicenseDao licenseDao = new LicenseDaoImpl();
//	@Override
//	public License login(String account, String code) {
//		License license = null;
//		License pass = licenseDao.select(account);
//		if (pass != null) {
//			if (
//			// pass.getLineID().equals(code)
//			// || pass.getFaceBookID().equals(code)
//			// || pass.getGoogleID().equals(code)||
//			pass.getPassword().equals(code)) {
//				license = pass;
//			}
//		}
//
//		return license;
//	}
//	@Override
//	public HttpSession loginSession(String account, HttpSession session) {
//		LimitsDaoImpl limitsDaoImpl = new LimitsDaoImpl();
//		MemberImpl memberImpl = new MemberImpl();
//		LicenseDaoImpl licenseDaoImpl = new LicenseDaoImpl();
//		Limits limits = limitsDaoImpl.select(account);
//		Member member = memberImpl.select(account);
//		License license = licenseDaoImpl.select(account);
//		session.setAttribute("limits", limits);
//		session.setAttribute("member", member);
//		session.setAttribute("license", license);
//
//		return session;
//	}
//	@Override
//	public void loginHistory(String account, String ip) {
//		try {
//			DbUtils.begin();
//			int uid = new MemberImpl().select(account).getUID();
//			LoginHistory loginHistory = new LoginHistory();
//			loginHistory.setUID(uid);
//			loginHistory.setAccount(account);
//			loginHistory.setIP(ip);
//			new LoginHistoryDaoImpl().insert(loginHistory);
//			DbUtils.commit();
//		} catch (Exception e) {
//			DbUtils.rollbacl();
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public Cookie rember(String rember) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public int LoginState(HttpServletRequest req, HttpServletResponse resp) {
//		return 0;
//	}
//
//}
