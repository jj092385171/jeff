package T4_36.dao;

import T4_36.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

	// 新增一筆記錄
	boolean insert(Category category) throws SQLException;

	// 依Pd_id來刪除單筆記錄
	int deleteByPd_id(int id) throws SQLException;

	int update(Category category) throws SQLException;

	Category selectByPdid(int Pdid) throws SQLException;

	List<Category> selectAll() throws SQLException;

	Category findImgByPdiD(int id) throws SQLException;

}