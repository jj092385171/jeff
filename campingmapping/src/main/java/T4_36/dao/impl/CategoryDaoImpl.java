package T4_36.dao.impl;

import T4_36.dao.CategoryDao;
import T4_36.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryDaoImpl implements CategoryDao {

	private final QueryRunner queryRunner = new QueryRunner();

	// 新增一筆記錄---
	@Override
	public boolean insert(Category category) throws SQLException {
		String sql = "INSERT INTO " + "category"
				+ " ( userID, Pdname, Pdtitle, Pdcontent, Pdtype, Pdpicture, Pdprice, Pdinventory, Pddate, Pdlastupdate) "
				+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Category result = queryRunner.insert(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
				category.getUserID(), category.getPdname(), category.getPdtitle(), category.getPdcontent(),
				category.getPdtype(), category.getPdpicture(), category.getPdprice(), category.getPdinventory(),
				category.getPddate(), category.getPdlastupdate());

		return Objects.nonNull(result);
	}

	// 依Pd_id來刪除單筆記錄
	@Override
	public int deleteByPd_id(int id) throws SQLException {
		String sql = "DELETE FROM category WHERE Pdid = ?";

		return queryRunner.update(DbUtils.getConnection(), sql, id);
	}

	// 修改一筆書籍資料
	@Override
	public int update(Category category) throws SQLException {
		String sql = "UPDATE category SET userID=?, Pdname =?, Pdtitle =?, Pdcontent =?, Pdtype =?, "
				+ "Pdprice =?, Pdinventory =?, Pdlastupdate =? WHERE Pdid = ?";

		return queryRunner.update(DbUtils.getConnection(), sql, category.getUserID(), category.getPdtitle(),
				category.getPdcontent(), category.getPdname(), category.getPdtype(), category.getPdprice(),
				category.getPdinventory(), category.getPdlastupdate(), category.getPdid());
	}

	@Override
	public Category selectByPd_id(int id) throws SQLException {
		String sql = "SELECT * FROM category WHERE Pdid = ?";

		return queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<Category>(Category.class), id);
	}

	// 透過Pdid找圖片
	@Override
	public Category findImgByPdiD(int id) throws SQLException {
		String sql = "select Pdpicture from category where Pdid = ? ";
		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, id);
		ResultSet rs = pre.executeQuery();
		rs.next();
		Category cg = new Category();
		cg.setPdpicture(rs.getBlob("img"));

		return cg;

	}

	@Override
	public List<Category> selectAll() {

		List<Category> categoryList = new ArrayList<>();

		String sql = "SELECT * FROM category";

		try (Connection connection = DbUtils.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				// 迴圈內將逐筆取出ResultSet內的紀錄
				while (rs.next()) {
					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
					Category category = new Category();
					category.setPdid(rs.getInt("Pdid"));
					category.setUserID(rs.getString("userID"));
					category.setPdname(rs.getString("Pdname"));
					category.setPdtitle(rs.getString("Pdtitle"));
					category.setPdcontent(rs.getString("Pdcontent"));
					category.setPdtype(rs.getString("Pdtype"));
					category.setPdpicture(rs.getBlob("Pdpicture"));
					category.setPdprice(rs.getInt("Pdprice"));
					category.setPdinventory(rs.getInt("Pdinventory"));
					category.setPddate(rs.getDate("Pddate"));
					category.setPdlastupdate(rs.getDate("Pdlastupdate"));
					// 最後將BookBean物件放入大的容器內
					categoryList.add(category);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return categoryList;
	}

}
