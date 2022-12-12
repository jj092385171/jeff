package T4_11.servletProject.servler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_11.bean.InitiatingBean;
import T4_11.servletProject.dao.InitiatingDaoImpl;

@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InitiatingDaoImpl iDao = new InitiatingDaoImpl();
		List<InitiatingBean> view = iDao.selectAllInitiating();
		List<InitiatingBean> camparea = iDao.selectAllCamparea();
		List<InitiatingBean> postmember = iDao.selectAllMember();
		
		request.setAttribute("view",view);
		request.setAttribute("camparea", camparea);
		request.setAttribute("postmember", postmember);
		

		RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Team.jsp");
		rd.forward(request, response);
	}
	

}
