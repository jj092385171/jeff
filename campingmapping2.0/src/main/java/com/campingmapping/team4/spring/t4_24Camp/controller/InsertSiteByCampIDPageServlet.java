package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
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

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;

import util.HibernateUtils;



@WebServlet("/T4_24/InsertSiteByCampIDPageServlet")
public class InsertSiteByCampIDPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//展示父營地, 新增site頁面
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		CampDao campDao = new CampDao(session);
		
		//營地編號
		String campIDSite = request.getParameter("campIDSite");
		if (campIDSite == null || campIDSite.trim().length() == 0) {
			errorMsg.put("campIDSite", "必須輸入營地編號");
		}
		Camp camp = campDao.findCampByID(Integer.valueOf(campIDSite));
		if(camp == null) {
			errorMsg.put("campIDSite", "查無此營地");
		}
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/InsertCampForm.jsp");
			rd.forward(request, response);
			return;
		}
	
		httpSession.setAttribute("camp", camp);
		
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/InsertSiteByIDForm.jsp"));
		return;
		
	}

}