package T4_24.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import T4_24.Models.CampSiteCityTagsBean;
import T4_24.Models.SiteBean;
import T4_24.Models.TagPlusCampBean;
import utils.DbUtils;

public class CampSiteCityTagsDao {

	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	
	
	//透過campID 查詢tags
	public List<TagPlusCampBean> findTagsByCampID(int campID) throws SQLException {
		String sql = "select * from TagPlusCamp where campID = ?";
		return qr.query(conn, sql, new BeanListHandler<TagPlusCampBean>(TagPlusCampBean.class), campID);
	}
	
	
	
	//查全部CampSiteCityTags
	public List<CampSiteCityTagsBean> showAll() throws SQLException {
		String sql = "select * from CampPlusCity";
		PreparedStatement preState = conn.prepareStatement(sql);
		List<CampSiteCityTagsBean> cctList = new ArrayList<>();
		List<TagPlusCampBean> tagList = null;
		List<SiteBean> siteList = null;

		ResultSet rs = preState.executeQuery();
		while (rs.next()) {
			CampSiteCityTagsBean cctBean = new CampSiteCityTagsBean();
			cctBean.setCampID(rs.getInt("campID"));
			cctBean.setCampName(rs.getString("campName"));
			cctBean.setCityID(rs.getInt("cityID"));
			cctBean.setCityName(rs.getString("cityName"));
			cctBean.setLocation(rs.getString("location"));
			cctBean.setCampPictures(rs.getBlob("campPictures"));
			cctBean.setDiscription(rs.getString("discription"));
			
			tagList = findTagsByCampID(cctBean.getCampID());
			cctBean.setTagList(tagList);
			
			SiteDao siteDao = new SiteDao();
			siteList = siteDao.findSitesByCampID(cctBean.getCampID());
			cctBean.setSiteList(siteList);

			cctList.add(cctBean);
		}

		rs.close();
		preState.close();

		return cctList;

	}

	// 透過cmapID查CampSiteCityTags
	public CampSiteCityTagsBean findCampByID(int campID) throws SQLException {
		String sql = "select * from CampPlusCity where campID = ?";
		PreparedStatement preState = conn.prepareStatement(sql);

		List<TagPlusCampBean> tagList = null;
		List<SiteBean> siteList = null;

		
		preState.setInt(1, campID);
		ResultSet rs = preState.executeQuery();
			

		if( !rs.next() ) {
			return null;
		}
		
		CampSiteCityTagsBean cctBean = new CampSiteCityTagsBean();
		cctBean.setCampID(rs.getInt("campID"));
		cctBean.setCampName(rs.getString("campName"));
		cctBean.setCityID(rs.getInt("cityID"));
		cctBean.setCityName(rs.getString("cityName"));
		cctBean.setLocation(rs.getString("location"));
		cctBean.setCampPictures(rs.getBlob("campPictures"));
		cctBean.setDiscription(rs.getString("discription"));
		
		tagList = findTagsByCampID(cctBean.getCampID());
		cctBean.setTagList(tagList);
		
		SiteDao siteDao = new SiteDao();
		siteList = siteDao.findSitesByCampID(cctBean.getCampID());
		cctBean.setSiteList(siteList);

		rs.close();
		preState.close();

		return cctBean;

	}

	// 透過cityID查CampSiteCityTags
	public List<CampSiteCityTagsBean> findCampsByCityID(int cityID) throws SQLException {
		String sql = "select * from CampPlusCity where cityID like ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		
		List<CampSiteCityTagsBean> cctList = new ArrayList<>();
		List<TagPlusCampBean> tagList = null;
		List<SiteBean> siteList = null;

		
		preState.setInt(1, cityID);
		ResultSet rs = preState.executeQuery();
		
		while (rs.next()) {
			CampSiteCityTagsBean cctBean = new CampSiteCityTagsBean();
			cctBean.setCampID(rs.getInt("campID"));
			cctBean.setCampName(rs.getString("campName"));
			cctBean.setCityID(rs.getInt("cityID"));
			cctBean.setCityName(rs.getString("cityName"));
			cctBean.setLocation(rs.getString("location"));
			cctBean.setCampPictures(rs.getBlob("campPictures"));
			cctBean.setDiscription(rs.getString("discription"));
			
			tagList = findTagsByCampID(cctBean.getCampID());
			cctBean.setTagList(tagList);
			
			SiteDao siteDao = new SiteDao();
			siteList = siteDao.findSitesByCampID(cctBean.getCampID());
			cctBean.setSiteList(siteList);
			
			cctList.add(cctBean);
		}

		rs.close();
		preState.close();

		return cctList;

	}

}
