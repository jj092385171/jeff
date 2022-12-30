package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.SiteDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;

import util.HibernateUtils;




@WebServlet("/T4_24/DeleteSiteByIDServlet")
public class DeleteSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		SiteDao siteDao = new SiteDao(session);
		Site site = null;

		String siteID = request.getParameter("siteID");
		if (siteID == null || siteID.trim().length() == 0) {
			errorMsg.put("siteID", "必須輸入營區位編號");
		}
		try {
			site = siteDao.findSiteByID(Integer.valueOf(siteID));
			if(site == null) {
				errorMsg.put("siteID", "查無此營區位");
			}
		} catch (NumberFormatException e) {
			errorMsg.put("siteID", "請輸入數字");
		} 
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/deletePage.jsp");
			rd.forward(request, response);
			return;
		}
		
		siteDao.deletdBySiteID(Integer.valueOf(siteID));
		
		httpSession.setAttribute("ID","siteID: " + siteID + " 刪除成功");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/DeleteByIDSuccess.jsp"));
	}

}
