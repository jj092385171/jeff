package com.campingmapping.team4.spring.t4_11Team.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_11Team.controller.TeamService;
import com.campingmapping.team4.spring.t4_11Team.model.Initiating;

import util.HibernateUtils;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println("回到view找資料");

		
		TeamService teamService = new TeamService(session);
		List<Initiating> view = teamService.selectAllInitiating();
		List<Initiating> camparea = teamService.selectAllCamparea();
		List<Initiating> postmember = teamService.selectAllMember();

		request.setAttribute("view", view);
		request.setAttribute("camparea", camparea);
		request.setAttribute("postmember", postmember);

		RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Team.jsp");
		rd.forward(request, response);
		System.out.println("in");
	}

}
