package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

import util.HibernateUtils;

@WebServlet("/T4_33/cancelReportPostServlet")
public class cancelReportPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			
			Post post = new Post();
			post.setPostId(Integer.parseInt(request.getParameter("postId"))); //取得postId
			PostService postService = new PostService(session); //送postId到資料庫
			postService.cancelReportPost(post);
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showForumManagerServlet");
			rd.forward(request, response);
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}
	}

}
