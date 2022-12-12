package T4_33.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import T4_01.ch01.registerServler;
import T4_33.bean.PostBean;
import T4_33.bean.PostCommentBean;

public class PostCommentDao {
	private Connection conn;

	public PostCommentDao(Connection conn) {
		this.conn = conn;
	}

	// 新增留言(OK)
	public Integer insertPostComment(PostCommentBean bean) throws SQLException {
		String sql = "insert into postComment values(?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getPostId());
		preState.setInt(2, bean.getUserId());
		preState.setString(3, bean.getPostComment());
		preState.setInt(4, 0);
		preState.setInt(5, 0);
		preState.executeUpdate();
		
		String sql2 = "select top 1 postCommentId from postComment order by postCommentId desc";
		preState = conn.prepareStatement(sql2);
		ResultSet rs = preState.executeQuery();
		rs.next();
		bean.setPostCommentId(rs.getInt("postCommentId"));
		preState.close();
		return bean.getPostCommentId();
		
	}

	// 修改留言
	public void updatePostComment(Integer postCommentId, String postComment) throws SQLException {
		String sql = "update postComment set postComment = ?, postCommentReport = ? where postCommentId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, postComment);
		preState.setInt(2, 0);
		preState.setInt(3, postCommentId);
		preState.executeUpdate();
		System.out.println("修改留言完成");
		preState.close();
	}

	// 檢舉留言
	public void reportPostComment(Integer postCommentId) throws SQLException {
		String getPostCommentReport = "select postCommentReport from postComment where postCommentId = ?";
		PreparedStatement preState = conn.prepareStatement(getPostCommentReport);
		preState.setInt(1, postCommentId);
		ResultSet rs = preState.executeQuery();
		PostBean bean = new PostBean();
		rs.next();
		if (rs.getInt("postCommentReport") != 1) {
//			bean.setPostCommentReport(rs.getInt("postCommentReport"));
			String sql = "update postComment set postCommentReport = ? where postCommentId = ?";
			preState = conn.prepareStatement(sql);
			preState.setInt(1, 1);
			preState.setInt(2, postCommentId);
			preState.executeUpdate();
			System.out.println("檢舉留言完成");
		} else {
			System.out.println("留言已被檢舉");
		}
		preState.close();
	}

	// 隱藏留言
	public void hidePostComment(Integer postCommentId) throws SQLException {
		String sql = "update postComment set postCommentHide = ? where postCommentId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, 1);
		preState.setInt(2, postCommentId);
		preState.executeUpdate();
		System.out.println("隱藏留言完成");
		preState.close();
	}

	// 刪除留言
	public void deletePostComment(Integer postCommentId) throws SQLException {
		String sql = "delete from postComment where postCommentId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postCommentId);
		preState.executeUpdate();
		System.out.println("刪除留言完成");
		preState.close();
	}
	
	// 刪除所有留言
		public void deletePostALLComment(Integer postId) throws SQLException {
			String sql = "delete from postComment where postId = ?";
			PreparedStatement preState = conn.prepareStatement(sql);
			preState.setInt(1, postId);
			preState.executeUpdate();
			preState.close();
		}

	// 依貼文查詢留言(OK)
	public List<PostCommentBean> selectPostComment(Integer postId) throws SQLException {
		String sql = "select * from postComment where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		List<PostCommentBean> list = new LinkedList<>();
		while(rs.next()) {
			PostCommentBean bean = new PostCommentBean();
			bean.setPostCommentId(rs.getInt("postCommentId"));
			bean.setUserId(rs.getInt("userId"));
			bean.setPostComment(rs.getString("postComment"));
			if(rs.getInt("postCommentHide") != 1) {
				list.add(bean);
			}
		}
		rs.close();
		preState.close();
		return list;
	}

	// 查詢被檢舉留言
	public void selectPostCommentReport() throws SQLException {
		String sql = "select * from postComment where postCommentReport = 1";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		selectPostCommentList(rs);
		rs.close();
		preState.close();
	}

	public void selectPostCommentList(ResultSet rs) throws SQLException {
//		List<PostBean> list = new LinkedList<>();
//		while (rs.next()) {
//			PostBean bean = new PostBean();
//			bean.setPostCommentId(rs.getInt("commentId")); // 取commentId
//			bean.setPostId(rs.getInt("postId")); // 取postId
//			bean.setUserId(rs.getInt("userId")); // 取userId
//			bean.setPostComment(rs.getString("comment")); // 取comment
//			bean.setPostCommentReport(rs.getInt("comReport")); // 取userId
//			bean.setPostCommentHide(rs.getInt("comHide")); // 取comHide
//			list.add(bean);
//		}
//		if (list.size() > 0) {
//			for (PostBean bean : list) {
//				System.out.println(bean.toString());
//			}
//		} else {
//			System.out.println("查無資料!");
//		}
	}
}
