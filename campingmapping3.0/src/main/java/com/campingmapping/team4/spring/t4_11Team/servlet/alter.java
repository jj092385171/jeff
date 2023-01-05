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

@WebServlet("/alter")
public class alter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public alter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		TeamService teamService = new TeamService(session);
		String alter = request.getParameter("alter");
		if (alter != null) {
			request.setAttribute("initiatingnum", alter);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Alter.jsp");
			rd.forward(request, response);
		}else {
			Map<String, String[]> params = request.getParameterMap();
			Initiating initiating = teamService.setInitiating(params);
			teamService.updateInitiating(initiating);
			RequestDispatcher rd = request.getRequestDispatcher("/view");
			rd.forward(request, response);
		}
	}

}
