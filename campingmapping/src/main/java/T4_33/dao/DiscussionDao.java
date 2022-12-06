package T4_33.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import T4_33.bean.DiscussionBean;

public class DiscussionDao {
	private Connection conn;

	public DiscussionDao(Connection conn) {
		this.conn = conn;
	}

	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 新增貼文
	
	public void insertPost(Integer userId, String title, String content, InputStream picture, Integer people,
			Integer price, String county, String stringStartDate, String stringEndDate, Integer score)
			throws SQLException, ParseException {
		String sql = "insert into post values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, userId); // 設定userId
		preState.setString(2, title); // 設定title
		preState.setString(3, content); // 設定content
		preState.setBinaryStream(4, picture); // 設定picture
		preState.setInt(5, people); // 設定people
		preState.setInt(6, price); // 設定price
		preState.setString(7, county); // 設定county
		Date utilStartDate = date.parse(stringStartDate);
		java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
		preState.setDate(8, startDate); // 設定startDate
		Date utilEndDate = date.parse(stringEndDate);
		java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());
		preState.setDate(9, endDate); // 設定endDate
		preState.setInt(10, score); // 設定score
		String stringReleaseDate = dateTime.format(new Date()); // 設定releaseDate
		Date utilReleaseDate = dateTime.parse(stringReleaseDate);
		// java.sql.Date releaseDate = new java.sql.Date(utilReleaseDate.getTime());
		// java.sql.Time releaseTime = new java.sql.Time(utilReleaseDate.getTime());
		java.sql.Timestamp releaseDate = new java.sql.Timestamp(utilReleaseDate.getTime());
		preState.setTimestamp(11, releaseDate);
		preState.setInt(12, 0); // 設定userLike
		preState.setInt(13, 0); // 設定userUnlike
		preState.setInt(14, 0); // 設定postReport
		preState.setInt(15, 0); // 設定postHide
		preState.executeUpdate();
		System.out.println("新增貼文完成");
		preState.close();
	}
	public void insertPost2(DiscussionBean d)
					throws SQLException, ParseException {
		String sql = "insert into post values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
//		preState.setInt(1, d.getUserId()); // 設定userId
		preState.setInt(1, 1); // 設定userId
		preState.setString(2, d.getTitle()); // 設定title
		preState.setString(3, d.getContent()); // 設定content
		preState.setBinaryStream(4, d.getPicture()); // 設定picture
		preState.setInt(5, d.getPeople()); // 設定people
		preState.setInt(6, d.getPrice()); // 設定price
		preState.setString(7, d.getCounty()); // 設定county
//		Date utilStartDate = date.parse(stringStartDate);
		java.sql.Date startDate = new java.sql.Date(d.getStartDate().getTime());
		preState.setDate(8, startDate); // 設定startDate
//		Date utilEndDate = date.parse(stringEndDate);
		java.sql.Date endDate = new java.sql.Date(d.getEndDate().getTime());
		preState.setDate(9, endDate); // 設定endDate
		preState.setInt(10, d.getScore()); // 設定score
		String stringReleaseDate = dateTime.format(new Date()); // 設定releaseDate
		Date utilReleaseDate = dateTime.parse(stringReleaseDate);
		// java.sql.Date releaseDate = new java.sql.Date(utilReleaseDate.getTime());
		// java.sql.Time releaseTime = new java.sql.Time(utilReleaseDate.getTime());
		java.sql.Timestamp releaseDate = new java.sql.Timestamp(utilReleaseDate.getTime());
		preState.setTimestamp(11, releaseDate);
		preState.setInt(12, 0); // 設定userLike
		preState.setInt(13, 0); // 設定userUnlike
		preState.setInt(14, 0); // 設定postReport
		preState.setInt(15, 0); // 設定postHide
		preState.executeUpdate();
		System.out.println("新增貼文完成");
		preState.close();
	}

	// 修改貼文
	public void updatePost(Integer postId, String title, String content, InputStream picture, Integer people,
			Integer price, String county, String stringStartDate, String stringEndDate, Integer score)
			throws SQLException, ParseException {
		String sql = "update post set title = ?, content = ?, picture = ?, people = ?, price = ?, county = ?, startDate = ?, endDate = ?, score = ?, releaseDate = ?, postReport = ? where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, title);
		preState.setString(2, content);
		preState.setBinaryStream(3, picture);
		preState.setInt(4, people);
		preState.setInt(5, price);
		preState.setString(6, county);
		Date utilStartDate = date.parse(stringStartDate);
		java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
		preState.setDate(7, startDate);
		Date utilEndDate = date.parse(stringEndDate);
		java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());
		preState.setDate(8, endDate);
		preState.setInt(9, score);
		String stringReleaseDate = dateTime.format(new Date()); // 修改releaseDate
		Date utilReleaseDate = dateTime.parse(stringReleaseDate);
		java.sql.Timestamp releaseDate = new java.sql.Timestamp(utilReleaseDate.getTime());
		preState.setTimestamp(10, releaseDate);
		preState.setInt(11, 0); // 修改postReport
		preState.setInt(12, postId); // 設定postId
		preState.executeUpdate();
		System.out.println("修改貼文完成");
		preState.close();
	}

	// 喜歡貼文
	public void likePost(Integer postId) throws SQLException {
		String getLike = "select userLike from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getLike);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		DiscussionBean bean = new DiscussionBean();
		rs.next();
		bean.setUserLike(rs.getInt("userLike"));
		String sql = "update post set userLike = ? where postId = ?";
		preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getUserLike() + 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		System.out.println("喜歡貼文完成");
		preState.close();
	}

	// 不喜歡貼文
	public void unlikePost(Integer postId) throws SQLException {
		String getUnlike = "select userUnlike from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getUnlike);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		DiscussionBean bean = new DiscussionBean();
		rs.next();
		bean.setUserUnlike(rs.getInt("userUnlike"));
		String sql = "update post set userUnlike = ? where postId = ?";
		preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getUserUnlike() + 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		System.out.println("不喜歡貼文完成");
		preState.close();
	}

	// 檢舉貼文
	public void reportPost(Integer postId) throws SQLException {
		String getPostReport = "select postReport from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getPostReport);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		DiscussionBean bean = new DiscussionBean();
		rs.next();
		if (rs.getInt("postReport") != 1) {
			bean.setPostReport(rs.getInt("postReport"));
			String sql = "update post set postReport = ? where postId = ?";
			preState = conn.prepareStatement(sql);
			preState.setInt(1, 1);
			preState.setInt(2, postId);
			preState.executeUpdate();
			System.out.println("檢舉貼文完成");
		} else {
			System.out.println("貼文已被檢舉");
		}
		preState.close();
	}

	// 隱藏貼文
	public void hidePost(Integer postId) throws SQLException {
		String sql = "update post set postHide = ? where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		System.out.println("隱藏貼文完成");
		preState.close();
	}

	// 刪除貼文
	public void deletePost(Integer postId) throws SQLException {
		String sql = "delete from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postId);
		preState.executeUpdate();
		System.out.println("刪除貼文完成");
		preState.close();
	}

	// 依標題查詢貼文
	public void selectPost(String title) throws SQLException {
		String sql = "select * from post where title like ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, "%" + title + "%");
		ResultSet rs = preState.executeQuery();
		selectPostList(rs);
		rs.close();
		preState.close();
	}

	// 查詢被檢舉貼文
	public void selectPostReport() throws SQLException {
		String sql = "select * from post where PostReport = 1";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		selectPostList(rs);
		rs.close();
		preState.close();
	}

	// 貼文查詢結果(共用方法)
	public void selectPostList(ResultSet rs) throws SQLException {
		List<DiscussionBean> list = new LinkedList<>();
		while (rs.next()) {
			DiscussionBean bean = new DiscussionBean();
			bean.setPostId(rs.getInt("postId")); // 取postId
			bean.setUserId(rs.getInt("userId")); // 取userId
			bean.setTitle(rs.getString("title")); // 取title
			bean.setContent(rs.getString("content")); // 取content
			bean.setPicture(rs.getBinaryStream("picture")); // 取picture
			bean.setPeople(rs.getInt("people")); // 取people
			bean.setPrice(rs.getInt("price")); // 取price
			bean.setCounty(rs.getString("county")); // 取county
			java.sql.Date sqlStartDate = rs.getDate("startDate"); // 取startDate
			Date utilStartDate = new Date(sqlStartDate.getTime());
			String stringStartDate = date.format(utilStartDate);
//			bean.setStartDate(stringStartDate);
			java.sql.Date sqlEndDate = rs.getDate("endDate"); // 取endDate
			Date utilEndDate = new Date(sqlEndDate.getTime());
			String stringEndDate = date.format(utilEndDate);
//			bean.setEndDate(stringEndDate);
			bean.setScore(rs.getInt("score")); // 取score
			java.sql.Timestamp sqlReleaseDate = rs.getTimestamp("releaseDate"); // 取releaseDate
			String stringReleaseDate = dateTime.format(sqlReleaseDate);
			bean.setReleaseDate(stringReleaseDate);
			bean.setUserLike(rs.getInt("userLike")); // 取userLike
			bean.setUserUnlike(rs.getInt("userUnlike")); // 取userUnlike
			bean.setPostReport(rs.getInt("postReport")); // 取postReport
			bean.setPostHide(rs.getInt("postHide")); // 取postHide
			list.add(bean);
		}
		if (list.size() > 0) {
			for (DiscussionBean bean : list) {
				System.out.println(bean.toString());
			}
		} else {
			System.out.println("查無資料!");
		}
	}

	// ---------------------------------------------------------------
	// 新增留言
	public void insertPostComment(Integer postId, Integer userId, String postComment) throws SQLException {
		String sql = "insert into postComment values(?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postId);
		preState.setInt(2, userId);
		preState.setString(3, postComment);
		preState.setInt(4, 0);
		preState.setInt(5, 0);
		preState.executeUpdate();
		System.out.println("新增留言完成");
		preState.close();
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
		DiscussionBean bean = new DiscussionBean();
		rs.next();
		if (rs.getInt("postCommentReport") != 1) {
			bean.setPostCommentReport(rs.getInt("postCommentReport"));
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

	// 依貼文查詢留言
	public void selectPostComment(Integer postId) throws SQLException {
		String sql = "select * from postComment where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		selectPostCommentList(rs);
		rs.close();
		preState.close();
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
		List<DiscussionBean> list = new LinkedList<>();
		while (rs.next()) {
			DiscussionBean bean = new DiscussionBean();
			bean.setPostCommentId(rs.getInt("commentId")); // 取commentId
			bean.setPostId(rs.getInt("postId")); // 取postId
			bean.setUserId(rs.getInt("userId")); // 取userId
			bean.setPostComment(rs.getString("comment")); // 取comment
			bean.setPostCommentReport(rs.getInt("comReport")); // 取userId
			bean.setPostCommentHide(rs.getInt("comHide")); // 取comHide
			list.add(bean);
		}
		if (list.size() > 0) {
			for (DiscussionBean bean : list) {
				System.out.println(bean.toString());
			}
		} else {
			System.out.println("查無資料!");
		}
	}
}
