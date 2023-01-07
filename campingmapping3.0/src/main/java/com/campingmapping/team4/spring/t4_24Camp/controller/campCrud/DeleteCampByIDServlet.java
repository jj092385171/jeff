package com.campingmapping.team4.spring.t4_24Camp.controller.campCrud;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;

import util.HibernateUtils;



@WebServlet("/DeleteCampByIDServlet.do")
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
		
		String campID = request.getParameter("campID");
		System.out.println(campID);
		campDao.deletdByCampID(Integer.valueOf(campID));
	
		httpSession.setAttribute("ID","campID: " + campID + " 刪除成功");
		
//		String contextPath = request.getContextPath();
//		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/DeleteByIDSuccess.jsp"));
//		return;
		
	}

}
