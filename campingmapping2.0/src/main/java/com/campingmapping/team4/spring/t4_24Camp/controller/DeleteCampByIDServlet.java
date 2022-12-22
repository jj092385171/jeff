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



@WebServlet("/T4_24/DeleteCampByIDServlet")
public class DeleteCampByIDServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		CampDao campDao = new CampDao(session);
		Camp camp = null;
		
		String campID = request.getParameter("campID");
		if (campID == null || campID.trim().length() == 0) {
			errorMsg.put("campID", "必須輸入營地編號");
		}
		try {
			camp = campDao.findCampByID(Integer.valueOf(campID));
			if(camp == null) {
				errorMsg.put("campID", "查無此營地");
			}
		} catch (NumberFormatException e) {
			errorMsg.put("campID", "請輸入數字");
		} 
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/deletePage.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		campDao.deletdByCampID(Integer.valueOf(campID));
	
		httpSession.setAttribute("ID","campID: " + campID + " 刪除成功");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/DeleteByIDSuccess.jsp"));
	}

}
