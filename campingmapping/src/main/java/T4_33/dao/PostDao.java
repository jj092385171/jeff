package T4_33.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import T4_33.bean.PostBean;

public class PostDao {
	private Connection conn;

	public PostDao(Connection conn) {
		this.conn = conn;
	}

	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 新增貼文(OK)
	public Integer insertPost(PostBean bean)throws SQLException, ParseException {
		String sql = "insert into post values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
//		preState.setInt(1, bean.getUserId()); // 設定userId
		preState.setInt(1, 1); // 設定userId
		preState.setString(2, bean.getTitle()); // 設定title
		preState.setString(3, bean.getContent()); // 設定content
		preState.setBinaryStream(4, bean.getPicture()); // 設定picture
		preState.setInt(5, bean.getPeople()); // 設定people
		preState.setInt(6, bean.getPrice()); // 設定price
		preState.setString(7, bean.getCounty()); // 設定county
		java.sql.Date startDate = new java.sql.Date(bean.getStartDate().getTime()); // 設定startDate
		preState.setDate(8, startDate); 
		java.sql.Date endDate = new java.sql.Date(bean.getEndDate().getTime()); // 設定endDate
		preState.setDate(9, endDate); 
		preState.setInt(10, bean.getScore()); // 設定score
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
		
		String sql2 = "select top 1 postId from post order by postId desc";
		preState = conn.prepareStatement(sql2);
		ResultSet rs = preState.executeQuery();
		rs.next();
		bean.setPostId(rs.getInt("postId"));
		preState.close();
		return bean.getPostId();
	}

	// 修改貼文(OK)
	public void updatePost(PostBean bean)throws SQLException, ParseException {
		String sql = "update post set title = ?, content = ?, picture = ?, people = ?, price = ?, county = ?, startDate = ?, endDate = ?, score = ?, releaseDate = ?, postReport = ? where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, bean.getTitle()); //修改title
		preState.setString(2, bean.getContent()); //修改content
		preState.setBinaryStream(3, bean.getPicture()); //修改picture
		preState.setInt(4, bean.getPeople()); //修改people
		preState.setInt(5, bean.getPrice()); //修改price
		preState.setString(6, bean.getCounty()); //修改county
		java.sql.Date startDate = new java.sql.Date(bean.getStartDate().getTime()); //修改startDate
		preState.setDate(7, startDate);
		java.sql.Date endDate = new java.sql.Date(bean.getEndDate().getTime()); //修改endDate
		preState.setDate(8, endDate);
		preState.setInt(9, bean.getScore()); //修改score
		String stringReleaseDate = dateTime.format(new Date()); // 修改releaseDate
		Date utilReleaseDate = dateTime.parse(stringReleaseDate);
		java.sql.Timestamp releaseDate = new java.sql.Timestamp(utilReleaseDate.getTime());
		preState.setTimestamp(10, releaseDate);
		preState.setInt(11, 0); // 修改postReport
		preState.setInt(12, bean.getPostId()); // 設定postId
		preState.executeUpdate();
		preState.close();
	}

	// 喜歡貼文
	public void likePost(Integer postId) throws SQLException {
		PostBean bean = new PostBean();
		String getLike = "select userLike from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getLike);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		rs.next();
		bean.setUserLike(rs.getInt("userLike"));
		String sql = "update post set userLike = ? where postId = ?";
		preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getUserLike() + 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		preState.close();
	}

	// 不喜歡貼文
	public void unlikePost(Integer postId) throws SQLException {
		PostBean bean = new PostBean();
		String getUnlike = "select userUnlike from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getUnlike);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		rs.next();
		bean.setUserUnlike(rs.getInt("userUnlike"));
		String sql = "update post set userUnlike = ? where postId = ?";
		preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getUserUnlike() + 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		preState.close();
	}

	// 檢舉貼文(OK)
	public String reportPost(Integer postId) throws SQLException {
		String getPostReport = "select postReport from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(getPostReport);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		PostBean bean = new PostBean();
		rs.next();
		String reportResult = null;
		if (rs.getInt("postReport") != 1) {
			bean.setPostReport(rs.getInt("postReport"));
			String sql = "update post set postReport = ? where postId = ?";
			preState = conn.prepareStatement(sql);
			preState.setInt(1, 1);
			preState.setInt(2, postId);
			preState.executeUpdate();
			reportResult = "檢舉貼文完成";
		} else {
			reportResult = "貼文已被檢舉";
		}
		preState.close();
		return reportResult;
	}

	// 隱藏貼文
	public String hidePost(Integer postId) throws SQLException {
		String sql = "update post set postHide = ? where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, 1);
		preState.setInt(2, postId);
		preState.executeUpdate();
		preState.close();
		return "隱藏貼文成功";
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

	//顯示所有貼文(OK)
	public List<PostBean> showDiscussionPost() throws SQLException {
		String sql = "select * from post order by releaseDate";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		List<PostBean> list = new LinkedList<>();
		while(rs.next()) {
			PostBean bean = new PostBean();
			bean.setPostId(rs.getInt("postId"));
			bean.setTitle(rs.getString("title"));
			if(rs.getInt("postHide") != 1) {
				list.add(bean);
			}
		}
		rs.close();
		preState.close();
		return list;
	}
	
	// 顯示某貼文(OK)
	public PostBean showPost(Integer postId) throws SQLException {
		PostBean bean = new PostBean();
		String sql = "select * from post where postId = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, postId);
		ResultSet rs = preState.executeQuery();
		rs.next();
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
		bean.setStartDate(utilStartDate);
		java.sql.Date sqlEndDate = rs.getDate("endDate"); // 取endDate
		Date utilEndDate = new Date(sqlEndDate.getTime());
		bean.setEndDate(utilEndDate);
		bean.setScore(rs.getInt("score")); // 取score
		java.sql.Timestamp sqlReleaseDate = rs.getTimestamp("releaseDate"); // 取releaseDate
		Date utilReleaseDate = new Date(sqlReleaseDate.getTime());
		bean.setReleaseDate(utilReleaseDate);
		bean.setUserLike(rs.getInt("userLike")); // 取userLike
		bean.setUserUnlike(rs.getInt("userUnlike")); // 取userUnlike
		bean.setPostReport(rs.getInt("postReport")); // 取postReport
		bean.setPostHide(rs.getInt("postHide")); // 取postHide
		rs.close();
		preState.close();
		return bean;
	}
	
	// 依標題查詢貼文
	public void selectPost(String title) throws SQLException {
		String sql = "select * from post where title like ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, "%" + title + "%");
		ResultSet rs = preState.executeQuery();
		List<PostBean> list = selectPostList(rs);
		rs.close();
		preState.close();
	}

	// 查詢被檢舉貼文
	public void selectPostReport() throws SQLException {
		String sql = "select * from post where postReport = 1";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		List<PostBean> list = selectPostList(rs);
		rs.close();
		preState.close();
	}
	
	//查詢隱藏貼文
	public List<PostBean> selectPostHide() throws SQLException {
		String sql = "select * from post where postHide = 1";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		List<PostBean> list = selectPostList(rs);
		rs.close();
		preState.close();
		return list;
	}

	// 貼文查詢結果(所有欄位)
	public List<PostBean> selectPostList(ResultSet rs) throws SQLException {
		List<PostBean> list = new LinkedList<>();
		while (rs.next()) {
			PostBean bean = new PostBean();
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
			bean.setStartDate(utilStartDate);
			java.sql.Date sqlEndDate = rs.getDate("endDate"); // 取endDate
			Date utilEndDate = new Date(sqlEndDate.getTime());
			bean.setEndDate(utilEndDate);
			bean.setScore(rs.getInt("score")); // 取score
			java.sql.Timestamp sqlReleaseDate = rs.getTimestamp("releaseDate"); // 取releaseDate
			Date utilReleaseDate = new Date(sqlReleaseDate.getTime());
			bean.setReleaseDate(utilReleaseDate);
			bean.setUserLike(rs.getInt("userLike")); // 取userLike
			bean.setUserUnlike(rs.getInt("userUnlike")); // 取userUnlike
			bean.setPostReport(rs.getInt("postReport")); // 取postReport
			bean.setPostHide(rs.getInt("postHide")); // 取postHide
			list.add(bean);
		}
		return list;
	}	
}
