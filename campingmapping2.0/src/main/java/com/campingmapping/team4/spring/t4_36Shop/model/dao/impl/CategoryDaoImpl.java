package com.campingmapping.team4.spring.t4_36Shop.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_36Shop.model.dao.CategoryDao;
import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

	private Session session;

	public CategoryDaoImpl(Session session) {
		this.session = session;
	}

	// 新增一筆記錄---
	public Category insert(Category category) {

		session.save(category);
		return category;
	}
//	@Override	
//	public boolean insert(Category category) throws SQLException {
//		String sql = "INSERT INTO " + "category"
//				+ " ( userID, Pdname, Pdtitle, Pdcontent, Pdtype, Pdpicture, Pdprice, Pdinventory, Pddate, Pdlastupdate) "
//				+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		Category result = queryRunner.insert(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
//				category.getUserID(), category.getPdname(), category.getPdtitle(), category.getPdcontent(),
//				category.getPdtype(), category.getPdpicture(), category.getPdprice(), category.getPdinventory(),
//				category.getPddate(), category.getPdlastupdate());
//
//		return Objects.nonNull(result);
//	}

	// 依Pd_id來刪除單筆記錄
	public Boolean deleteByPd_id(int id) {
		Category category = session.get(Category.class, id);

		if (category != null) {
			session.delete(category);
			return true;
		}

		return false;
	}
//	@Override
//	public int deleteByPd_id(int id) throws SQLException {
//		String sql = "DELETE FROM category WHERE Pdid = ?";
//
//		return queryRunner.update(DbUtils.getConnection(), sql, id);
//	}

	// 修改一筆書籍資料
	public Category update(Integer pdid, String userID, String pdname, String pdtitle, String pdcontent, String pdtype,
			Blob pdpicture, int pdprice, int pdinventory, Date pdlastupdate) {
		Category category = session.get(Category.class, pdid);

		if (category != null) {
			category.setPdid(pdid);
			category.setUserID(userID);
//			category.setuserID(session.get(member.class, userID));
			category.setPdname(pdname);
			category.setPdtitle(pdtitle);
			category.setPdcontent(pdcontent);
			category.setPdtype(pdtype);
			category.setPdpicture(pdpicture);
			category.setPdprice(pdprice);
			category.setPdinventory(pdinventory);
			category.setPdlastupdate(pdlastupdate);

			return category;
		}

		return null;
	}

//	@Override
//	public int update(Category category) throws SQLException {
//		String sql = "UPDATE category SET userID=?, Pdname =?, Pdtitle =?, Pdcontent =?, Pdtype =?, "
//				+ "Pdprice =?, Pdinventory =?, Pdlastupdate =? WHERE Pdid = ?";
//
//		return queryRunner.update(DbUtils.getConnection(), sql, category.getUserID(), category.getPdtitle(),
//				category.getPdcontent(), category.getPdname(), category.getPdtype(), category.getPdprice(),
//				category.getPdinventory(), category.getPdlastupdate(), category.getPdid());
//	}
	// 使用Pdid搜尋
	public Category selectByPdid(int Pdid) {
		Category category = session.get(Category.class, Pdid);

		if (category != null) {
			return category;
		}

		return null;
	}
//	@Override
//	public Category selectByPdid(int id) throws SQLException {
//		String sql = "SELECT Pdid,userID,Pdname,Pdtitle,Pdcontent,Pdtype,Pdprice,Pdinventory,Pddate,Pdlastupdate FROM category WHERE Pdid = ?";
//
//		return queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<Category>(Category.class), id);
//	}

	// 透過Pdid找圖片
//	@Override
//	public Category findImgByPdiD(int id) throws SQLException {
//		String sql = "select Pdpicture from category where Pdid = ? ";
//		Connection connection = DbUtils.getConnection();
//		PreparedStatement pre = connection.prepareStatement(sql);
//		pre.setInt(1, id);
//		ResultSet rs = pre.executeQuery();
//		rs.next();
//		Category cg = new Category();
//		cg.setPdpicture(rs.getBlob("Pdpicture"));
//
//		return cg;
//
//	}
	// 搜尋全部
	public List<Category> selectAll() {
		Query<Category> query = session.createQuery("from Category", Category.class);
		List<Category> resultList = query.getResultList();

		return resultList;
	}
//	@Override
//	public List<Category> selectAll() {
//
//		List<Category> categoryList = new ArrayList<>();
//
//		String sql = "SELECT * FROM category";
//
//		try (Connection connection = DbUtils.getConnection();
//				PreparedStatement ps = connection.prepareStatement(sql);) {
//			try (ResultSet rs = ps.executeQuery();) {
//				// 只要還有紀錄未取出，rs.next()會傳回true
//				// 迴圈內將逐筆取出ResultSet內的紀錄
//				while (rs.next()) {
//					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
//					Category category = new Category();
//					category.setPdid(rs.getInt("Pdid"));
//					category.setUserID(rs.getString("userID"));
//					category.setPdname(rs.getString("Pdname"));
//					category.setPdtitle(rs.getString("Pdtitle"));
//					category.setPdcontent(rs.getString("Pdcontent"));
//					category.setPdtype(rs.getString("Pdtype"));
//					category.setPdpicture(rs.getBlob("Pdpicture"));
//					category.setPdprice(rs.getInt("Pdprice"));
//					category.setPdinventory(rs.getInt("Pdinventory"));
//					category.setPddate(rs.getDate("Pddate"));
//					category.setPdlastupdate(rs.getDate("Pdlastupdate"));
//					// 最後將BookBean物件放入大的容器內
//					categoryList.add(category);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//
//		return categoryList;
//	}

}
