package T4_24.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityPlusTagsBean;
import T4_24.Models.TagBean;
import T4_24.Models.TagPlusCampBean;
import utils.DbUtils;

public class CampPlusCityPlusTagsDao {

	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//透過campID 查詢tags
	public List<TagPlusCampBean> findTagsByCampID(int campID) throws SQLException {
		String sql = "select * from CampPlusCityPlusTag where campID = ?";
		return qr.query(conn, sql, new BeanListHandler<TagPlusCampBean>(TagPlusCampBean.class), campID);
	}
	
	//透過tagID 查詢tags
	public TagPlusCampBean findTagNameByTagID(int tagID) throws SQLException{
		String sql = "select * from CampPlusCityPlusTag where tagID = ?";
		return (TagPlusCampBean) qr.query(conn, sql, new BeanHandler<TagPlusCampBean>(TagPlusCampBean.class), tagID);
	}

	
	//查全部camps和cityName和tags
	public List<CampPlusCityPlusTagsBean> showAll() throws SQLException {
		String sql = "select * from CampPlusCity";
		PreparedStatement preState = conn.prepareStatement(sql);
		List<CampPlusCityPlusTagsBean> cctList = new ArrayList<>();
		List<TagPlusCampBean> tagList = null;

		ResultSet rs = preState.executeQuery();
		while (rs.next()) {
			CampPlusCityPlusTagsBean cctBean = new CampPlusCityPlusTagsBean();
			cctBean.setCampID(rs.getInt("campID"));
			cctBean.setCampName(rs.getString("campName"));
			cctBean.setCityID(rs.getInt("cityID"));
			cctBean.setCityName(rs.getString("cityName"));
			cctBean.setLocation(rs.getString("location"));
			cctBean.setCampPictures(rs.getBlob("campPictures"));
			cctBean.setDiscription(rs.getString("discription"));
			
			tagList = findTagsByCampID(cctBean.getCampID());
			cctBean.setTagList(tagList);

			cctList.add(cctBean);
		}

		rs.close();
		preState.close();

		return cctList;

	}

	// 透過cmapID查camp和cityName和tags
	public CampPlusCityPlusTagsBean findCampByID(int campID) throws SQLException {
		String sql = "select * from CampPlusCity where campID = ?";
		PreparedStatement preState = conn.prepareStatement(sql);

		List<TagPlusCampBean> tagList = null;

		
		preState.setInt(1, campID);
		ResultSet rs = preState.executeQuery();
		rs.next();

		CampPlusCityPlusTagsBean cctBean = new CampPlusCityPlusTagsBean();
		cctBean.setCampID(rs.getInt("campID"));
		cctBean.setCampName(rs.getString("campName"));
		cctBean.setCityID(rs.getInt("cityID"));
		cctBean.setCityName(rs.getString("cityName"));
		cctBean.setLocation(rs.getString("location"));
		cctBean.setCampPictures(rs.getBlob("campPictures"));
		cctBean.setDiscription(rs.getString("discription"));
		
		tagList = findTagsByCampID(cctBean.getCampID());
		cctBean.setTagList(tagList);

		rs.close();
		preState.close();

		return cctBean;

	}

	// 透過cityID查camps和cityName和tags
	public List<CampPlusCityPlusTagsBean> findCampsByCityID(int cityID) throws SQLException {
		String sql = "select * from CampPlusCity where cityID like ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		
		List<CampPlusCityPlusTagsBean> cctList = new ArrayList<>();
		List<TagPlusCampBean> tagList = null;


		preState.setInt(1, cityID);
		ResultSet rs = preState.executeQuery();
		while (rs.next()) {
			CampPlusCityPlusTagsBean cctBean = new CampPlusCityPlusTagsBean();
			cctBean.setCampID(rs.getInt("campID"));
			cctBean.setCampName(rs.getString("campName"));
			cctBean.setCityID(rs.getInt("cityID"));
			cctBean.setCityName(rs.getString("cityName"));
			cctBean.setLocation(rs.getString("location"));
			cctBean.setCampPictures(rs.getBlob("campPictures"));
			cctBean.setDiscription(rs.getString("discription"));
			
			tagList = findTagsByCampID(cctBean.getCampID());
			cctBean.setTagList(tagList);

			cctList.add(cctBean);
		}

		rs.close();
		preState.close();

		return cctList;

	}

}
