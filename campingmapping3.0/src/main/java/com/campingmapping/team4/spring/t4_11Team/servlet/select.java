package com.campingmapping.team4.spring.t4_11Team.servlet;

import java.io.IOException;
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

@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public select() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		TeamService teamService = new TeamService(session);
		List<Initiating> view = teamService.selectAllInitiating();
		List<Initiating> camparea = teamService.selectAllCamparea();
		List<Initiating> postmember = teamService.selectAllMember();
		

		request.setAttribute("view",view);
		
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String num = request.getParameter("initiatingnum");
		String member = request.getParameter("postmember");
		String area = request.getParameter("camparea");
		
		String hql = teamService.hqlCommand(startdate, enddate, num, member, area);
		List<Initiating> view1 = teamService.selectInitiating(hql);
		

		
		request.setAttribute("camparea", camparea);
		request.setAttribute("postmember", postmember);
		request.setAttribute("view2",view1);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Team.jsp");
		rd.forward(request, response);
	}

}
