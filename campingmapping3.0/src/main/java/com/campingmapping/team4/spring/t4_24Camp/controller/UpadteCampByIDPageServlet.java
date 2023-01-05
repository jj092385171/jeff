package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.util.HashMap;

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

import util.HibernateUtils;


@WebServlet("/UpadteCampByIDPageServlet.do")
public class UpadteCampByIDPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 更新頁面, camp, 顯示所有citys, tags
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		// 存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		String campID = request.getParameter("campID");
		
		CampDao campDao = new CampDao(session);
		Camp camp = campDao.findCampByID(Integer.valueOf(campID));

		request.setAttribute("camp", camp);

		RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/UpdateCampByIDForm.jsp");
		rd.forward(request, response);
		return;

	}

}
