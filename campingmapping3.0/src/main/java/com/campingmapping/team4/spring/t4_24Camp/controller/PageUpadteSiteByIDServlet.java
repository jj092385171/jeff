package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.SiteDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;

import util.HibernateUtils;




@WebServlet("/PageUpadteSiteByIDServlet")
public class PageUpadteSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//更新頁面, site ,顯示父營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		SiteDao siteDao = new SiteDao(session);

		String siteID = request.getParameter("siteID");

		Site site = siteDao.findSiteByID(Integer.valueOf(siteID));
			
		request.setAttribute("site", site);	
		
		RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/UpdateSiteByIDForm.jsp");
		rd.forward(request, response);
		return;
		
	}

}
