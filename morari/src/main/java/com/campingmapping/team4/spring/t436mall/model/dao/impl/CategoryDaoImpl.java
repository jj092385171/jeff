package com.campingmapping.team4.spring.t436mall.model.dao.impl;
// package com.campingmapping.team4.spring.t4_36Mall.model.dao.impl;

// import org.hibernate.Session;
// import org.hibernate.query.Query;

// import com.campingmapping.team4.spring.t4_36Mall.model.dao.CategoryDao;
// import com.campingmapping.team4.spring.t4_36Mall.model.entity.Category;

// import java.util.List;

// public class CategoryDaoImpl implements CategoryDao {

// private Session session;

// public CategoryDaoImpl(Session session) {
// this.session = session;
// }

// // 新增一筆記錄---
// public Category insert(Category category) {

// session.save(category);
// return category;
// }

// // 依Pd_id來刪除單筆記錄
// public Boolean deleteByPd_id(int id) {
// Category category = session.get(Category.class, id);

// if (category != null) {
// session.delete(category);
// return true;
// }

// return false;
// }

// // 修改一筆產品資料
// public void update(Category category) {
// Category updateByPdid = session.get(Category.class, category.getPdid());

// if (updateByPdid != null) {
// session.saveOrUpdate(category);
// }
// }

// // 使用Pdid搜尋
// public Category selectByPdid(int Pdid) {
// Category category = session.get(Category.class, Pdid);

// if (category != null) {
// return category;
// }

// return null;
// }

// // 透過Pdid找圖片
// // @Override
// // public Category findImgByPdiD(int id) throws SQLException {
// // String sql = "select Pdpicture from category where Pdid = ? ";
// // Connection connection = DbUtils.getConnection();
// // PreparedStatement pre = connection.prepareStatement(sql);
// // pre.setInt(1, id);
// // ResultSet rs = pre.executeQuery();
// // rs.next();
// // Category cg = new Category();
// // cg.setPdpicture(rs.getBlob("Pdpicture"));
// //
// // return cg;
// //
// // }
// // 搜尋全部
// public List<Category> selectAll() {
// Query<Category> query = session.createQuery("from Category", Category.class);
// List<Category> resultList = query.getResultList();

// return resultList;
// }

// }
