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

@WebServlet("/T4_33/updatePostServlet")
public class updatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			Post post = new Post();
			String postId = request.getParameter("postId"); //取得傳送來的postId
			post.setPostId(Integer.parseInt(postId)); 
			String title = request.getParameter("title"); //取得更新的title
			post.setTitle(title);
			String content = request.getParameter("content"); //取得更新的content
			post.setContent(content);
//			String stringPicture = request.getParameter("picture"); //取得更新的picture
//			System.out.println(stringPicture);
//			InputStream isPicture = null;
//			if(stringPicture != "") {
//				isPicture = new ByteArrayInputStream(stringPicture.getBytes()); //String要轉成inputStream
//			}
//			bean.setPicture(isPicture);
			
//			String picture = request.getParameter("picture"); //取得更新的picture
//			if(picture != "") {
////				String path=request.getSession().getServletContext().getRealPath("/")+"/imgs";
////				OutputStream out = new FileOutputStream(new File(path, picture));
//				picture = "../imgs/" + picture; //
//			}
//			post.setPicture(picture);
//			System.out.println(picture);
			
			String stringPeople = request.getParameter("people"); //取得更新的people
			int people = 0;
			if(stringPeople != "") {
				people = Integer.parseInt(stringPeople);
			}
			post.setPeople(people);
			String stringPrice = request.getParameter("price"); //取得更新的price
			int price = 0;
			if(stringPrice != "") {
				price = Integer.parseInt(stringPrice);
			}
			post.setPrice(price);
			String county = request.getParameter("county"); //取得更新的county
			post.setCounty(county);
			String stringStartDate = request.getParameter("startDate"); //取得更新的startDate
			Date startDate = null;
			if(stringStartDate != "") {
				startDate = date.parse(stringStartDate); //--> String轉成utilDate
			}
			post.setStartDate(startDate);
			String stringEndDate = request.getParameter("endDate"); //取得更新的endDate
			Date endDate = null;
			if(stringEndDate != "") {
				endDate = date.parse(stringEndDate); //--> String轉成utilDate
			}
			post.setEndDate(endDate);
			String stringScore = request.getParameter("score"); //取得更新的score
			int score = 0;
			if(stringScore != "") {
				score = Integer.parseInt(stringScore);
			}
			post.setScore(score);
			
			PostService postService = new PostService(session); //送到資料庫更新post
			postService.updatePost(post); 
			
			List<Post> list = postService.selectAllPost();
			for(Post p : list) {
				System.out.println(p.getStartDate());
			}
			httpSession.setAttribute("postList", list);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
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
