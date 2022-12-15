package T4_24.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import T4_24.Models.TagBean;
import utils.DbUtils;

public class TagDao {
	
//	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//搜尋全部標籤
	public List<TagBean> showAll() throws SQLException {
		String sql = "select * from tag";
		return qr.query(DbUtils.getConnection(), sql, new BeanListHandler<TagBean>(TagBean.class));	
	}
	
}
