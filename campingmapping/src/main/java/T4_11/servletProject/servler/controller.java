package T4_11.servletProject.servler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_11.bean.InitiatingBean;
import T4_11.servletProject.dao.InitiatingDaoImpl;

@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String parameter = request.getParameter("member");
		InitiatingDaoImpl iDao = new InitiatingDaoImpl();
		Map<String, String[]> params = request.getParameterMap();
		InitiatingBean initiatingBean = iDao.setInitiatingBean(params);
		System.out.println(initiatingBean.getPostmember());
		iDao.insertInitiating(initiatingBean);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_11/TestResult.jsp");
			rd.forward(request, response);
		

		return;
	}
	
}
