package T4_24.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import T4_24.Models.TagBean;
import T4_24.Models.TagPlusCampBean;
import utils.DbUtils;

public class TagPlusCampDao {
	
	Connection conn = DbUtils.getConnection();
	QueryRunner qr = new QueryRunner();
	
	//透過tagID 查詢營地的標籤名
	public TagPlusCampBean findTagNameByTagID(int tagID) throws SQLException{
		String sql = "select * from TagPlusCamp where tagID = ?";
		return (TagPlusCampBean) qr.query(conn, sql, new BeanHandler(TagPlusCampBean.class), tagID);
	}
	
	//透過campID 查詢營地的標籤名
	public List<TagPlusCampBean> findTagNameByCampID(int campID) throws SQLException{
		String sql = "select * from TagPlusCamp where campID = ?";
		return qr.query(conn, sql, new BeanListHandler<TagPlusCampBean>(TagPlusCampBean.class), campID);
	}

}
