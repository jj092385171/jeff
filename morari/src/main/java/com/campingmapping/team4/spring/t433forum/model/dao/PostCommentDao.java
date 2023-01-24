package com.campingmapping.team4.spring.t433forum.model.dao;
// package com.campingmapping.team4.spring.t4_33Forum.model.dao;

// import java.sql.SQLException;
// import java.util.List;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;

// import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
// import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

// import util.HibernateUtils;

// public class PostCommentDao {

// private SessionFactory factory;

// public PostCommentDao() {
// //取得工廠
// this.factory = HibernateUtils.getSessionFactory();
// }

// // 依貼文查所有留言
// public List<PostComment> selectPostComment(PostComment postComment) throws
// SQLException {
// // 取得連線
// Session session = factory.getCurrentSession();
// String hql = "from PostComment where postId = ?1 and postCommentHide != 1";
// List<PostComment> resultList = session.createQuery(hql,
// PostComment.class).setParameter(1,
// postComment.getPost().getPostId()).getResultList();
// return resultList;
// }

// // 新增留言
// public void insertPostComment(PostComment postComment) throws SQLException {
// // 取得連線
// Session session = factory.getCurrentSession();
// session.save(postComment);
// }

// // 修改留言
// public void updatePostComment(PostComment postComment) throws SQLException {
// Session session = factory.getCurrentSession();
// PostComment result = session.get(PostComment.class,
// postComment.getPostCommentId());
// if(result != null) {
// result.setPostComment(postComment.getPostComment());
// result.setPostCommentReport(postComment.getPostCommentReport());
// }
// }

// // 檢舉留言
// public Boolean reportPostComment(PostComment postComment) throws SQLException
// {
// Session session = factory.getCurrentSession();
// PostComment result = session.get(PostComment.class,
// postComment.getPostCommentId());
// if(result != null && result.getPostCommentReport() == 0) {
// result.setPostCommentReport(postComment.getPostCommentReport());
// return true;
// }
// return false;
// }

// // 查詢被檢舉留言
// public List<PostComment> selectReportPostComment(PostComment postComment)
// throws SQLException {
// // 取得連線
// Session session = factory.getCurrentSession();
// String hql = "from PostComment where postCommentReport = ?1";
// List<PostComment> resultList = session.createQuery(hql,
// PostComment.class).setParameter(1,
// postComment.getPostCommentReport()).getResultList();
// return resultList;
// }

// // 取消檢舉留言
// public Boolean cancelReportPostComment(PostComment postComment) throws
// SQLException {
// Session session = factory.getCurrentSession();
// PostComment result = session.get(PostComment.class,
// postComment.getPostCommentId());
// if(result != null) {
// result.setPostCommentReport(postComment.getPostCommentReport());
// return true;
// }
// return false;
// }

// // 變更是否隱藏留言
// public void changeHidePostComment(PostComment postComment) throws
// SQLException {
// Session session = factory.getCurrentSession();
// PostComment result = session.get(PostComment.class,
// postComment.getPostCommentId());
// if(result != null) {
// result.setPostCommentHide(postComment.getPostCommentHide());
// }
// }
// }
