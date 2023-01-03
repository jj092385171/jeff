package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/T4_33/showReportPostServlet")
public class showReportPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			PostService postService = new PostService(session); // 送postId到資料庫
			List<Post> list = postService.selectReportPost(); // 回傳隱藏貼文list
			
			httpSession.setAttribute("postReportList", list); // 送list到showReportPost
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showReportPost.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/admin/showReportPost.jsp"));
			return;
		
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
