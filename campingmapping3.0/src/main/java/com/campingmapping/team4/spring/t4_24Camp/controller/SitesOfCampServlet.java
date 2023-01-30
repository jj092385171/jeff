package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;

import util.HibernateUtils;


@WebServlet("/SitesOfCampServlet.do")
public class SitesOfCampServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	//ShowSitesOfCamp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		String campID = request.getParameter("campID");
		
		CampDao campDao = new CampDao(session);
		Camp camp = campDao.findCampByID(Integer.valueOf(campID));
		Set<Site> sites = camp.getSites();
		
		
		request.setAttribute("sites", sites);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("t4_24camp/admin/SitesOfCamp.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
