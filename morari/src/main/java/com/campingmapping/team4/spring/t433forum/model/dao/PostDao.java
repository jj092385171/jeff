package com.campingmapping.team4.spring.t433forum.model.dao;
// package com.campingmapping.team4.spring.t4_33Forum.model.dao;

// import java.sql.SQLException;
// import java.text.SimpleDateFormat;
// import java.util.List;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;

// import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
// import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

// import util.HibernateUtils;

// public class PostDao {

// private SessionFactory factory;

// public PostDao() {
// // 取得工廠
// this.factory = HibernateUtils.getSessionFactory();
// }

// SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// // 查所有貼文
// public List<Post> selectAllPost(Post post) {
// Session session = factory.getCurrentSession();
// String hql = "from Post where postHide != ?1 order by releaseDate desc";
// List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1,
// post.getPostHide()).getResultList();
// return resultList;
// }
// // 查單一貼文
// public Post selectSinglePost(Post post) {
// Session session = factory.getCurrentSession();
// String hql = "from Post where postId = ?1";
// Post singleResult = session.createQuery(hql, Post.class).setParameter(1,
// post.getPostId()).getSingleResult();
// return singleResult;
// }
// // 查會員貼文

// // 新增貼文
// public void insertPost(Post post)throws SQLException{
// // 取得連線
// Session session = factory.getCurrentSession();
// session.save(post);
// }

// // 修改貼文
// public void updatePost(Post post) throws SQLException {
// Session session = factory.getCurrentSession();
// Post result = session.get(Post.class, post.getPostId());
// if(result != null) {
// result.setTitle(post.getTitle());
// result.setContent(post.getContent());
// result.setPeople(post.getPeople());
// result.setPrice(post.getPrice());
// result.setCounty(post.getCounty());
// result.setStartDate(post.getStartDate());
// result.setEndDate(post.getEndDate());
// result.setScore(post.getScore());
// result.setReleaseDate(post.getReleaseDate());
// result.setPostReport(post.getPostReport());
// }
// }

// // 喜歡貼文

// // 不喜歡貼文

// // 檢舉貼文
// public Boolean reportPost(Post post) throws SQLException {
// Session session = factory.getCurrentSession();
// Post result = session.get(Post.class, post.getPostId());
// if(result != null && result.getPostReport() == 0) {
// result.setPostReport(post.getPostReport());
// return true;
// }
// return false;
// }

// // 查詢被檢舉貼文
// public List<Post> selectReportPost(Post post) throws SQLException {
// Session session = factory.getCurrentSession();
// String hql = "from Post where postReport = ?1";
// List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1,
// post.getPostReport()).getResultList();
// return resultList;
// }

// // 取消檢舉貼文
// public Boolean cancelReportPost(Post post) throws SQLException {
// Session session = factory.getCurrentSession();
// Post result = session.get(Post.class, post.getPostId());
// if(result != null) {
// result.setPostReport(post.getPostReport());
// return true;
// }
// return false;
// }

// // 變更是否隱藏貼文
// public void changeHidePost(Post post) throws SQLException {
// Session session = factory.getCurrentSession();
// Post result = session.get(Post.class, post.getPostId());
// if(result != null) {
// result.setPostHide(post.getPostHide());
// }
// }
// }
