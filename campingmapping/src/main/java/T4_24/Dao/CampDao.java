package T4_24.Dao;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import T4_24.Models.*;
import utils.DbUtils;

public class CampDao {
	
//		Connection conn = DbUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		//新增營地
		public BigDecimal AddCamp(CampBean bean) throws SQLException {
			String sql = "insert into camp(campName, cityID, location, campPictures, discription) values(?,?,?,?,?)";
			Object[] params = { bean.getCampName(), bean.getCityID(), bean.getLocation(), bean.getCampPictures(), bean.getDiscription() };
			return qr.insert(DbUtils.getConnection(), sql, new ScalarHandler<>(), params);	
		}
		
		//刪除營地, 要先刪除營地的標籤 , 刪除包含的營區位
		public void deletdByCampID(int campID) throws SQLException {
			TagOfCampDao tagOfCampDao = new TagOfCampDao();
			tagOfCampDao.deletdByCampID(campID);
			SiteDao siteDao = new SiteDao();
			siteDao.deleteByCampID(campID);
			String sql = "delete from camp where campID = ?";
			qr.update(DbUtils.getConnection(),sql,campID);
		}

		//透過campID更新
		public void updateByCampID(String campName, int cityID, String location, Blob campPictures, String discription, int campID) throws SQLException {
			String sql = "update camp set campName = ?, cityID = ?, location = ?, campPictures = ?, discription = ? where campID = ?";
			qr.update(DbUtils.getConnection(),sql,campName, cityID, location, campPictures, discription, campID);
		}
		
		//透過id找圖片
		public CampBean findPictures(int id) throws SQLException {
			Connection conn = DbUtils.getConnection();
			String sql = "select campPictures from camp where campID = ?";
			PreparedStatement preState = conn.prepareStatement(sql);
			preState.setInt(1, id);
			
			ResultSet rs = preState.executeQuery();
			rs.next();
			
			CampBean campBean = new CampBean();
			campBean.setCampPictures(rs.getBlob("campPictures"));
			
			return campBean;
			
		}
		
		public Blob fileToBlob(InputStream is, long size) {
			try {
				DbUtils.begin();

				byte[] b = new byte[(int) size];
				SerialBlob sb = null;
				is.read(b);
				sb = new SerialBlob(b);
				DbUtils.commit();
				return sb;

			} catch (Exception e) {
				DbUtils.rollbacl();
				e.printStackTrace();
				return null;
			}
		}
		
		

}
