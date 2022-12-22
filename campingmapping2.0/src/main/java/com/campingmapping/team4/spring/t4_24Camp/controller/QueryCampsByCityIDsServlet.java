package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CityDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;

import util.HibernateUtils;



@WebServlet("/T4_24/QueryCampsByCityIDsServlet")
public class QueryCampsByCityIDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//透過cityIDs搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		
		String[] cityIDs = request.getParameterValues("cityID");
		if (cityIDs == null || cityIDs.length == 0) {
			errorMsg.put("cityIDs", "必須勾選縣市");
		}

		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/QueryPageForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		CityDao cityDao = new CityDao(session);
		List<Camp> camps = new ArrayList<Camp>();
		
		for(String cityID : cityIDs) {
			 camps.addAll(cityDao.findCampsByCityID(Integer.valueOf(cityID)));
		}
		
		httpSession.setAttribute("camps", camps);
		
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/t4_24camp/admin/QueryByCityIDsResult.jsp") ); 
		return;
				
				
	}

}
