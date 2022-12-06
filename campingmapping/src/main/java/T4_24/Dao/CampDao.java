package T4_24.Dao;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
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
		public BigDecimal Add(CampBean bean) throws SQLException {
			String sql = "insert into camp(campName, cityID, location, campPictures, discription) values(?,?,?,?,?)";
			Object[] params = { bean.getCampName(), bean.getCityID(), bean.getLocation(), bean.getCampPictures(), bean.getDiscription() };
			return qr.insert(conn, sql, new ScalarHandler<>(), params);	
		}
		
		
		//搜尋全部營地
		public List<CampBean> show() throws SQLException {
			String sql = "select * from camp";
			return qr.query(conn, sql, new BeanListHandler<CampBean>(CampBean.class));	
		}
		
		public CampBean findByID(int campID) throws SQLException {
			String sql = "select campID from camp where campID = ?";
			return qr.query(conn, sql, new BeanHandler<CampBean>(CampBean.class),campID);	
		}
		
		//部分搜尋
		public List<CampBean> findByCityID(int cityID) throws SQLException {
			String sql = "select * from camp where cityID = ?";
			return qr.query(conn, sql, new BeanListHandler<CampBean>(CampBean.class), cityID);
		}
		
		//刪除營地,要先刪除營地的標籤
		public void deletdByCampID(int campID) throws SQLException {
			TagOfCampDao tagOfCampDao = new TagOfCampDao();
			tagOfCampDao.deletdByCampID(campID);
			String sql = "delete from camp where campID = ?";
			qr.update(conn,sql,campID);
		}
		

}
