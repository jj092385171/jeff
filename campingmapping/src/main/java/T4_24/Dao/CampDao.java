package T4_24.Dao;
import java.io.InputStream;
import java.math.BigDecimal;
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
		
		//透過cmapID查camp
		public CampBean findCampByID(int campID) throws SQLException {
			String sql = "select * from camp where campID = ?";
			PreparedStatement preState = conn.prepareStatement(sql);
			
			preState.setInt(1, campID);
			ResultSet rs = preState.executeQuery();
			rs.next();
			
			CampBean cb = new CampBean();
			cb.setCampID(rs.getInt("campID"));
			cb.setCampName(rs.getString("campName"));
			cb.setCityID(rs.getInt("cityID"));
			cb.setLocation(rs.getString("location"));
			cb.setCampPictures(rs.getBlob("campPictures"));
			cb.setDiscription(rs.getString("discription"));
			
			rs.close();
			preState.close();
			
			return cb;
			
		}
		
		//透過cityID查camps
		public List<CampBean> findCampsByCityID(int cityID) throws SQLException {
			String sql = "select * from camp where cityID like ?";
			PreparedStatement preState = conn.prepareStatement(sql);
			List<CampBean> cbList = new ArrayList<>();
			
			preState.setInt(1, cityID);
			ResultSet rs = preState.executeQuery();
			while( rs.next() ) {
				CampBean cb = new CampBean();
				cb.setCampID(rs.getInt("campID"));
				cb.setCampName(rs.getString("campName"));
				cb.setCityID(rs.getInt("cityID"));
				cb.setLocation(rs.getString("location"));
				cb.setCampPictures(rs.getBlob("campPictures"));
				cb.setDiscription(rs.getString("discription"));
				
				cbList.add(cb);
			}
			
			rs.close();
			preState.close();
			
			return cbList;
			
		}
		
		//刪除營地,要先刪除營地的標籤
		public void deletdByCampID(int campID) throws SQLException {
			TagOfCampDao tagOfCampDao = new TagOfCampDao();
			tagOfCampDao.deletdByCampID(campID);
			String sql = "delete from camp where campID = ?";
			qr.update(conn,sql,campID);
		}
		

}
