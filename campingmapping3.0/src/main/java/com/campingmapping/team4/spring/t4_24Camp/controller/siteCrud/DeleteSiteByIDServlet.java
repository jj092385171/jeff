package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

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

import util.HibernateUtils;




@WebServlet("/DeleteSiteByIDServlet.do")
public class DeleteSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		SiteDao siteDao = new SiteDao(session);

		String siteID = request.getParameter("siteID");
		
		siteDao.deletdBySiteID(Integer.valueOf(siteID));
		
		request.setAttribute("ID","siteID: " + siteID + " 刪除成功");
		
		RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/DeleteByIDSuccess.jsp");
		rd.forward(request, response);
		return;
	}

}
