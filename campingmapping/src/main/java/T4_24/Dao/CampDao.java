package T4_24.Dao;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import T4_24.Models.*;
import utils.DbUtils;

public class CampDao {
	
		Connection conn = DbUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		//新增營地
		public BigDecimal AddCamp(CampBean bean) throws SQLException {
			String sql = "insert into camp(campName, cityID, location, campPictures, discription) values(?,?,?,?,?)";
			Object[] params = { bean.getCampName(), bean.getCityID(), bean.getLocation(), bean.getCampPictures(), bean.getDiscription() };
			return qr.insert(conn, sql, new ScalarHandler<>(), params);	
		}
		
		//刪除營地,要先刪除營地的標籤
		public void deletdByCampID(int campID) throws SQLException {
			TagOfCampDao tagOfCampDao = new TagOfCampDao();
			tagOfCampDao.deletdByCampID(campID);
			String sql = "delete from camp where campID = ?";
			qr.update(conn,sql,campID);
		}

		//透過campID更新
		public void updateByCampID(String campName, int cityID, String location, Blob campPictures, String discription, int campID) throws SQLException {
			String sql = "update camp set campName = ?, cityID = ?, location = ?, campPictures = ?, discription = ? where campID = ?";
			qr.update(conn,sql,campName, cityID, location, campPictures, discription, campID);
		}
		
		

}
