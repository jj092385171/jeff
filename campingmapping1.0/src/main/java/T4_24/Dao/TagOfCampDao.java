package T4_24.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;


import utils.DbUtils;

public class TagOfCampDao {
	
//	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
//	
	//新增營地的標籤
	public void Add(int tagID, int campID) throws SQLException {
		
		String sql = "insert into tagOfCamp values(?,?)";
		qr.update(DbUtils.getConnection(),sql,tagID,campID);
	}
	
	//刪除營地的標籤(刪除. 更新營地的前置)
	public void deletdByCampID(int campID) throws SQLException {
		String sql = "delete from tagOfCamp where campID = ?";
		qr.update(DbUtils.getConnection(),sql,campID);
	}

}
