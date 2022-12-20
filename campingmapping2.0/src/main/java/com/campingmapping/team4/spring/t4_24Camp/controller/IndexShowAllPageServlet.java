package controller;

import java.io.IOException;
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

import T4_24.dao.CampDao;
import T4_24.model.Camp;
import tw.hibernatedemo.util.HibernateUtil;



@WebServlet("/T4_24/IndexShowAllPageServlet")
public class IndexShowAllPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//showAll
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpsession = request.getSession();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampDao campDao = new CampDao(session);
		List<Camp> showAll = campDao.showAll();
		
		httpsession.setAttribute("showALL", showAll);
		
		RequestDispatcher rd = request.getRequestDispatcher("/T4_24/CampIndex.jsp");
		rd.forward(request, response);
		

		return;
		
	}
}
