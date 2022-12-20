package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import T4_24.dao.CityDao;
import T4_24.dao.TagDao;
import T4_24.model.City;
import T4_24.model.Tag;
import tw.hibernatedemo.util.HibernateUtil;



@WebServlet("/T4_24/InsertPageServlet")
public class InsertPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//新增頁面, 顯示所有citys, tags
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TagDao tagDao = new TagDao(session);
		CityDao cityDao = new CityDao(session);

		List<Tag> tagList = tagDao.showAll();
		request.setAttribute("tagList", tagList);
		List<City> cityList = cityDao.showAll();
		request.setAttribute("cityList", cityList);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertCampForm.jsp");
		rd.forward(request, response);
		return;
		
	}

}
