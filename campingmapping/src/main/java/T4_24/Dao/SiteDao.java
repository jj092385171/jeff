package T4_24.Dao;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import T4_24.Models.CampBean;
import T4_24.Models.SiteBean;
import utils.DbUtils;


public class SiteDao {
	
	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//新增營區位
	public BigDecimal AddSite(SiteBean bean) throws SQLException {
		String sql = "insert into site(siteName, sitePictures, totalSites, siteMoney, campID) values(?,?,?,?,?)";
		Object[] params = { bean.getSiteName(), bean.getSitePictures(), bean.getTotalSites(), bean.getSiteMoney(), bean.getCampID() };
		return qr.insert(conn, sql, new ScalarHandler<>(), params);	
	}
	
	//透過campID查site
	public List<SiteBean> findSitesByCampID(int campID) throws SQLException {	
	    String sql = "select * from site where campid = ?";
	    PreparedStatement preState = conn.prepareStatement(sql);
	    preState.setInt(1, campID);
	    
	    List<SiteBean> siteList = new ArrayList<>();
	    ResultSet rs = preState.executeQuery();
	    
	    while (rs.next()) {
			SiteBean siteBean = new SiteBean();
			siteBean.setSiteID(rs.getInt("siteID"));
			siteBean.setSiteName(rs.getString("siteName"));
			siteBean.setSitePictures(rs.getBlob("sitePictures"));
			siteBean.setTotalSites(rs.getInt("totalSites"));
			siteBean.setSiteMoney(rs.getInt("siteMoney"));
			siteBean.setCampID(rs.getInt("campID"));
			
			siteList.add(siteBean);
		}
	    
	    rs.close();
	    preState.close();
	    return siteList;
		
	}

	//透過siteID查詢site
	public SiteBean findSiteBySiteID(int siteID) throws SQLException {
		String sql = "select * from site where siteID = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		
		preState.setInt(1, siteID);
		ResultSet rs = preState.executeQuery();
		
		if( !rs.next() ) {
			return null;
		}
		
		
		SiteBean siteBean = new SiteBean();
		siteBean.setSiteID(rs.getInt("siteID"));
		siteBean.setSiteName(rs.getString("siteName"));
		siteBean.setSitePictures(rs.getBlob("sitePictures"));
		siteBean.setTotalSites(rs.getInt("totalSites"));
		siteBean.setSiteMoney(rs.getInt("siteMoney"));
		siteBean.setCampID(rs.getInt("campID"));
		
		rs.close();
	    preState.close();
	    return siteBean;
		
	}
	
	//透過siteID修改site
	public void updateBySiteID(String siteName, Blob sitePictures, int totalSites, int siteMoney, int siteID) throws SQLException {
		String sql = "update site set siteName = ?, sitePictures = ?, totalSites = ?, siteMoney = ? where siteID = ?";
		qr.update(conn,sql,siteName, sitePictures, totalSites, siteMoney, siteID);
	}
	
	//透過siteID刪除site
	public void deleteBySiteID(int siteID) throws SQLException {
		String sql = "delete from site where siteID = ?";
		qr.update(conn, sql, siteID);
	}
	
	//透過campID刪除site, 刪除營地的前置
	public void deleteByCampID(int campID) throws SQLException {
		String sql = "delete from site where campID = ?";
		qr.update(conn, sql, campID);
	}
	
	//透過id找圖片
	public CampBean findPictures(int id) throws SQLException {
		String sql = "select campPictures from camp where siteID = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, id);
		
		ResultSet rs = preState.executeQuery();
		rs.next();
		
		CampBean campBean = new CampBean();
		campBean.setCampPictures(rs.getBlob("campPictures"));
		
		return campBean;
		
	}

}
