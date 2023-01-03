package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.dao.CityDao;
import com.campingmapping.team4.spring.t4_24Camp.model.dao.TagDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;
import util.*;




@WebServlet("/IndexShowCampsServlet")
public class IndexShowCampsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//showAllCamp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpsession = request.getSession();
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampDao campDao = new CampDao(session);
		TagDao tagDao = new TagDao(session);
		CityDao cityDao = new CityDao(session);
		
		List<Camp> allCamps = campDao.showAll();
		List<Tag> tagList = tagDao.showAll();
		List<City> cityList = cityDao.showAll();
		
		httpsession.setAttribute("allCamps", allCamps);
		httpsession.setAttribute("tagList", tagList);
		httpsession.setAttribute("cityList", cityList);
		
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/CampIndex.jsp"));
		return;
		
	}
}
