package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.bean.PostBean;
import T4_33.bean.PostCommentBean;
import T4_33.dao.PostCommentDao;
import T4_33.dao.PostDao;
import utils.DbUtils;

@WebServlet("/T4_33/showPostServlet")
public class showPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			DbUtils.begin();
			request.setCharacterEncoding("UTF-8");
			
			int postId = 0; //取得postId
			if(request.getParameter("postId") != null) {
				postId = Integer.parseInt(request.getParameter("postId"));
			}else {
				postId = Integer.parseInt(request.getAttribute("postId").toString());
			}	
			
			PostDao dao = new PostDao(DbUtils.getConnection()); //送postId到資料庫取貼文內容
			PostBean bean = dao.showPost(postId); //回傳bean
			
			PostCommentDao comDao = new PostCommentDao(DbUtils.getConnection()); //送postId到資料庫取留言
			List<PostCommentBean> comList = comDao.selectPostComment(postId); //回傳list
			
			request.setAttribute("title", bean.getTitle()); //顯示title
			request.setAttribute("content", bean.getContent()); //顯示content
			if(bean.getPicture() != null) { //顯示picture
				request.setAttribute("picture", bean.getPicture()); //--> 顯示圖片還沒做！！！！！！！！！！！！！！！！！！！！！
			}
			if(bean.getPeople() != 0) { //顯示people
				request.setAttribute("people", bean.getPeople());
			}
			if(bean.getPrice() != 0) { //顯示price
				request.setAttribute("price", bean.getPrice());
			}
			if(bean.getCounty() != null) { //顯示county
				request.setAttribute("county", bean.getCounty());
			}
			if(bean.getStartDate() != null) { //顯示startDate
				request.setAttribute("startDate", date.format(bean.getStartDate())); //--> utilDate轉成String
			}
			if(bean.getEndDate() != null) { //顯示endDate
				request.setAttribute("endDate", date.format(bean.getEndDate())); //--> utilDate轉成String
			}
			if(bean.getScore() != 0) { //顯示score
				request.setAttribute("score", bean.getScore());
			}
			request.setAttribute("releaseDate", dateTime.format(bean.getReleaseDate())); //顯示releaseDate
			request.setAttribute("userLike", bean.getUserLike()); //顯示userLike
			request.setAttribute("userUnlike", bean.getUserUnlike()); //顯示userUnlike
			
			request.setAttribute("postId", postId); //送postId到showPost
			request.setAttribute("comList", comList); //送comList到showPost
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPost.jsp");
			rd.forward(request, response);
			DbUtils.commit();
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

	
}
