package T4_01.servlerProject.service.impl;

import T4_01.beans.License;
import T4_01.beans.Member;
import T4_01.dao.LicenseDao;
import T4_01.dao.impl.LicenseDaoImpl;
import T4_01.servlerProject.service.loginService;
import utils.DbUtils;

public class loginServiceImpl implements loginService {
	 private LicenseDao licenseDao =  new LicenseDaoImpl();
	@Override
	public Member login(String account, String core) {
		License license =null;
		DbUtils.begin();
		License select = licenseDao.select(account);
		if (select!=null) {
			
		}
		
		return null;
	}

}
