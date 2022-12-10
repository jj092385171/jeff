package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import T4_01.beans.License;
import T4_01.dao.LicenseDao;
import utils.DbUtils;

public class LicenseDaoImpl implements LicenseDao {
	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public License insert(License license) {
		try {
			License insert = queryRunner.insert(DbUtils.getConnection(),
					"INSERT INTO license (UID ,account ,FaceBookID ,GoogleID ,LineID ,password) VALUES (?,?,?,?,?,?)",
					new BeanHandler<License>(License.class),license.getUID(), license.getAccount(),
					license.getFaceBookID(), license.getGoogleID(),
					license.getLineID(), license.getPassword());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int delete(String account) {
		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"DELETE FROM license WHERE account =?", account);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(License license) {
		try {
			int insert = queryRunner.update(DbUtils.getConnection(),
					"UPDATE license SET account = ? ,FaceBookID = ? ,GoogleID = ? ,LineID = ? ,password = ? WHERE UID = ?",
					license.getAccount(), license.getFaceBookID(),
					license.getGoogleID(), license.getLineID(),
					license.getPassword(), license.getUID());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public License select(String account) {
		try {
			License query = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM license WHERE account = ?",
					new BeanHandler<License>(License.class), account);
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<License> selectAll() {
		return null;
	}

}
