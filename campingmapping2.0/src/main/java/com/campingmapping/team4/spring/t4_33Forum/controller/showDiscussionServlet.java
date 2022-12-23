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

@WebServlet("/T4_33/showDiscussionServlet")
public class showDiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			PostDao dao = new PostDao(DbUtils.getConnection());
			List<PostBean> list = dao.showDiscussionPost();
			
			request.setAttribute("postList", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/discussionFirst.jsp");
			rd.forward(request, response);
			DbUtils.commit();
			return;
		
		} catch (IOException | ServletException | SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		
		
	}

}
