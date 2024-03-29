package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

import util.HibernateUtils;


@WebServlet("/T4_33/newPostServlet")
public class newPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			Post post = new Post();
			//取得輸入的title
			String title = request.getParameter("title"); 
			post.setTitle(title);
			//取得輸入的content
			String content = request.getParameter("content"); 
			post.setContent(content);
			//取得輸入的people
			String stringPeople = request.getParameter("people"); 
			int people = 0;
			if(stringPeople != "") {
				people = Integer.parseInt(stringPeople);
			}
			post.setPeople(people);
			//取得輸入的price
			String stringPrice = request.getParameter("price"); 
			int price = 0;
			if(stringPrice != "") {
				price = Integer.parseInt(stringPrice);
			}
			post.setPrice(price);
			//取得輸入的county
			String county = request.getParameter("county"); 
			post.setCounty(county);
			//取得輸入的startDate
			String stringStartDate = request.getParameter("startDate"); 
			Date startDate = null;
			if(stringStartDate != "") {
				startDate = date.parse(stringStartDate); //--> String轉成utilDate
			}
			post.setStartDate(startDate);
			//取得輸入的endDate
			String stringEndDate = request.getParameter("endDate"); 
			Date endDate = null;
			if(stringEndDate != "") {
				endDate = date.parse(stringEndDate); //--> String轉成utilDate
			}
			post.setEndDate(endDate);
			//取得輸入的score
			String stringScore = request.getParameter("score"); 
			int score = 0;
			if(stringScore != "") {
				score = Integer.parseInt(stringScore);
			}
			post.setScore(score);
			
			PostService postService = new PostService(session); //送到資料庫建立post
			postService.insertPost(post);
			
			
			List<Post> list = postService.selectAllPost();
			httpSession.setAttribute("postList", list);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPost.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			
			int userId = 9;
			if(userId == 9) {
				response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/admin/ForumManagerFirst.jsp"));
				return;
			}
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/guest/discussionFirst.jsp"));
			return;
			
		} catch (IOException | ParseException | SQLException e) {
			e.printStackTrace();
		}
	}
}
