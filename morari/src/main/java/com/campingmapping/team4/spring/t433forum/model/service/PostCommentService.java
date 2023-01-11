package com.campingmapping.team4.spring.t433forum.model.service;
// package com.campingmapping.team4.spring.t4_33Forum.model.service;

// import java.sql.SQLException;
// import java.util.List;

// import com.campingmapping.team4.spring.t4_33Forum.model.dao.PostCommentDao;
// import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

// public class PostCommentService {

// private PostCommentDao postCommentDao;

// public PostCommentService() {
// this.postCommentDao = new PostCommentDao();
// }

// // 依貼文查所有留言
// public List<PostComment> selectPostComment(PostComment postComment) throws
// SQLException{
// return postCommentDao.selectPostComment(postComment);
// }

// // 新增留言
// public void insertPostComment(PostComment postComment) throws SQLException{
// postComment.setPostCommentReport(0);
// postComment.setPostCommentHide(0);
// postCommentDao.insertPostComment(postComment);
// }

// // 修改留言
// public void updatePostComment(PostComment postComment) throws SQLException{
// postComment.setPostCommentReport(0);
// postCommentDao.updatePostComment(postComment);
// }

// // 檢舉留言
// public Boolean reportPostComment(PostComment postComment) throws
// SQLException{
// postComment.setPostCommentReport(1);
// return postCommentDao.reportPostComment(postComment);
// }

// // 查詢被檢舉留言
// public List<PostComment> selectReportPostComment(PostComment postComment)
// throws SQLException{
// postComment.setPostCommentReport(1);
// return postCommentDao.selectReportPostComment(postComment);
// }

// // 取消檢舉留言
// public Boolean cancelReportPostComment(PostComment postComment) throws
// SQLException{
// postComment.setPostCommentReport(2);
// return postCommentDao.cancelReportPostComment(postComment);
// }

// // 隱藏留言
// public void hidePostComment(PostComment postComment) throws SQLException{
// postComment.setPostCommentHide(1);
// postCommentDao.changeHidePostComment(postComment);
// }

// // 取消隱藏留言
// public void cancelHidePostComment(PostComment postComment) throws
// SQLException{
// postComment.setPostCommentHide(0);
// postCommentDao.changeHidePostComment(postComment);
// }
// }
