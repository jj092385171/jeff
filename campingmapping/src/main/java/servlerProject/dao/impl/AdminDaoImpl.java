package servlerProject.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import servlerProject.dao.AdminDao;
import servlerProject.entity.Admin;
import servlerProject.utils.DbUtils;

public class AdminDaoImpl implements AdminDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public int insert(Admin admin) {
		return 0;
	}

	@Override
	public int delete(int username) {
		return 0;
	}

	@Override
	public int update(Admin admin) {
		return 0;
	}

	@Override
	public Admin select(int username) {
		try {
			Admin admin = queryRunner.query(DbUtils.getConnection(), " SELECT * FROM member WHERE UID = ? ",
					new BeanHandler<Admin>(Admin.class), username);
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Admin> selectAll() {
		try {
			List<Admin> admins = queryRunner.query(DbUtils.getConnection(), "SELECT * FROM member ",
					new BeanListHandler<Admin>(Admin.class));
			return admins;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
