package T4_01.servlerProject.service.impl;

import java.util.List;

import T4_01.servlerProject.dao.AdminDao;
import T4_01.servlerProject.dao.impl.AdminDaoImpl;
import T4_01.servlerProject.entity.Admin;
import T4_01.servlerProject.service.AdminService;
import utils.DbUtils;



public  class AdminServiceImpl implements AdminService {

	private AdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin login(int UID, String password) {
		Admin result =null;
		try {
			DbUtils.begin();
			Admin admin = adminDao.select(UID);
			if (admin!=null) {
				if (admin.getPassword().equals(password)) {
					result = admin;
				}
			}
			DbUtils.commit();
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Admin> showAllAdmin() {
		List<Admin> admins = null;
		try {
			DbUtils.begin();
			admins=adminDao.selectAll();
			DbUtils.commit();
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		return admins;
	}

}
