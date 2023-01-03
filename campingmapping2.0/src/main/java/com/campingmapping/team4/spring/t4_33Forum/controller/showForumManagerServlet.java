package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

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

@WebServlet("/T4_33/showForumManagerServlet")
public class showForumManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			PostService postService = new PostService(session);
			List<Post> list = postService.selectAllPost();
			
			httpSession.setAttribute("postList", list);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/discussionFirst.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/admin/ForumManagerFirst.jsp"));
			return;
			
		} catch (IOException | SQLException | ParseException e) {
			e.printStackTrace();
		}
	}

}
