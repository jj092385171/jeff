package T4_24.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityBean;
import utils.DbUtils;

public class CampPlusCityDao {

	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();

	//查全部camps和cityName
	public List<CampPlusCityBean> showAll() throws SQLException {
		String sql = "select * from CampPlusCity";
		PreparedStatement preState = conn.prepareStatement(sql);
		List<CampPlusCityBean> cpcList = new ArrayList<>();

		ResultSet rs = preState.executeQuery();
		while (rs.next()) {
			CampPlusCityBean cpc = new CampPlusCityBean();
			cpc.setCampID(rs.getInt("campID"));
			cpc.setCampName(rs.getString("campName"));
			cpc.setCityID(rs.getInt("cityID"));
			cpc.setCityName(rs.getString("cityName"));
			cpc.setLocation(rs.getString("location"));
			cpc.setCampPictures(rs.getBlob("campPictures"));
			cpc.setDiscription(rs.getString("discription"));

			cpcList.add(cpc);
		}

		rs.close();
		preState.close();

		return cpcList;

	}

	// 透過cmapID查camp和cityName
	public CampPlusCityBean findCampByID(int campID) throws SQLException {
		String sql = "select * from CampPlusCity where campID = ?";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setInt(1, campID);
		ResultSet rs = preState.executeQuery();
		rs.next();

		CampPlusCityBean cpc = new CampPlusCityBean();
		cpc.setCampID(rs.getInt("campID"));
		cpc.setCampName(rs.getString("campName"));
		cpc.setCityID(rs.getInt("cityID"));
		cpc.setCityName(rs.getString("cityName"));
		cpc.setLocation(rs.getString("location"));
		cpc.setCampPictures(rs.getBlob("campPictures"));
		cpc.setDiscription(rs.getString("discription"));

		rs.close();
		preState.close();

		return cpc;

	}

	// 透過cityID查camps和cityName
	public List<CampPlusCityBean> findCampsByCityID(int cityID) throws SQLException {
		String sql = "select * from CampPlusCity where cityID like ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		List<CampPlusCityBean> cpcList = new ArrayList<>();

		preState.setInt(1, cityID);
		ResultSet rs = preState.executeQuery();
		while (rs.next()) {
			CampPlusCityBean cpc = new CampPlusCityBean();
			cpc.setCampID(rs.getInt("campID"));
			cpc.setCampName(rs.getString("campName"));
			cpc.setCityID(rs.getInt("cityID"));
			cpc.setCityName(rs.getString("cityName"));
			cpc.setLocation(rs.getString("location"));
			cpc.setCampPictures(rs.getBlob("campPictures"));
			cpc.setDiscription(rs.getString("discription"));

			cpcList.add(cpc);
		}

		rs.close();
		preState.close();

		return cpcList;

	}

}
