package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

@WebServlet("/T4_33/showDiscussionServlet")
public class showDiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			
			PostService postService = new PostService();
			List<Post> list = postService.selectAllPost();
			
			session.setAttribute("postList", list);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/discussionFirst.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/guest/discussionFirst.jsp"));
			return;
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
