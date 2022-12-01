package T4_24.Do;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import T4_24.Models.*;
import utils.DbUtils;

public class CampDao {
	
		Connection conn = DbUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		
		public void Add(CampBean bean) throws SQLException {
			String sql = "INSERT INTO camp values(?,?,?,?,?)";
			qr.update(conn, sql, bean.getCampName(), bean.getCity(), bean.getLocation(), bean.getCampPictures(), bean.getDiscription());	
		}

}
