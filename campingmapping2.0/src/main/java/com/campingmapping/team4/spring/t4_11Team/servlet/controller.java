package com.campingmapping.team4.spring.t4_11Team.servlet;

import java.io.IOException;
import java.util.Map;

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

@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		TeamService teamService = new TeamService(session);
		Map<String, String[]> params = request.getParameterMap();
		
		Initiating initiating = teamService.setInitiating(params);
		teamService.insertInitiating(initiating);
			RequestDispatcher rd = request.getRequestDispatcher("/view");
			rd.forward(request, response);
		
	}
	
}
