package T4_24.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import T4_24.Models.CampBean;
import T4_24.Models.TagBean;
import utils.DbUtils;

public class TagDao {
	
	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//搜尋全部
	public List<TagBean> show() throws SQLException {
		String sql = "select * from tag";
		return qr.query(conn, sql, new BeanListHandler<TagBean>(TagBean.class));	
	}

}
