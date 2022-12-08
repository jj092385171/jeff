package T4_01.service.impl;


import javax.servlet.http.HttpSession;

import T4_01.beans.License;
import T4_01.beans.Limits;
import T4_01.beans.Member;
import T4_01.dao.LicenseDao;
import T4_01.dao.impl.LicenseDaoImpl;
import T4_01.dao.impl.LimitsDaoImpl;
import T4_01.dao.impl.MemberImpl;
import T4_01.service.LoginService;
import utils.DbUtils;

public class LoginServiceImpl implements LoginService {
	private LicenseDao licenseDao = new LicenseDaoImpl();
	@Override
	public License login(String account, String code) {
		License license = null;
		try {
			DbUtils.begin();
			License pass = licenseDao.select(account);
			System.out.println(pass.toString());
			if (pass != null) {
				if (
//						pass.getLineID().equals(code)
//						|| pass.getFaceBookID().equals(code)
//						|| pass.getGoogleID().equals(code)||
						 pass.getPassword().equals(code)
						 ) {
					license = pass;
				}
			}
			DbUtils.commit();
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		return license;
	}
	@Override
	public HttpSession loginSession(String account,HttpSession session) {
		LimitsDaoImpl limitsDaoImpl = new LimitsDaoImpl();
		MemberImpl memberImpl = new MemberImpl();
		Limits limits = limitsDaoImpl.select(account);
		Member member =memberImpl.select(account);
		session.setAttribute("Limits", limits);
		session.setAttribute("member", member);
		session.setAttribute(account, member);
		
		return session;
	}
	
}
