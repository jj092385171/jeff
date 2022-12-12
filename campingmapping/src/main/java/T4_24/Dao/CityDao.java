package T4_24.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_24.Models.CityBean;
import utils.DbUtils;

public class CityDao {
	
	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//搜尋全部城市
	public List<CityBean> showAll() throws SQLException {
		String sql = "select * from city";
		return qr.query(conn, sql, new BeanListHandler<CityBean>(CityBean.class));	
	}
	
	
	
//	//透過cityID查詢cityName
//	public CityBean findCityNameByCityID(int cityID) throws SQLException {
//		String sql = "select * from city where cityID = ?";
//		return (CityBean) qr.query(conn, sql, new BeanHandler(CityBean.class), cityID);	
//	}
	

}
