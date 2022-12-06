package T4_24.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import T4_24.Models.CampBean;
import T4_24.Models.TagBean;
import T4_24.Models.TagOfCampBean;
import utils.DbUtils;

public class TagDao {
	
	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//透過標籤ID 查詢營地的標籤名
	public TagBean findTagNameByTagID(int tagID) throws SQLException{
		String sql = "select * from tag where tagID = ?";
		return (TagBean) qr.query(conn, sql, new BeanHandler(TagBean.class), tagID);
	}
	
	//搜尋全部
	public List<TagBean> show() throws SQLException {
		String sql = "select * from tag";
		return qr.query(conn, sql, new BeanListHandler<TagBean>(TagBean.class));	
	}

}
