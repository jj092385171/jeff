package T4_11.servletProject.servler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_11.bean.InitiatingBean;
import T4_11.servletProject.dao.InitiatingDaoImpl;

@WebServlet("/alter")
public class alter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public alter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		InitiatingDaoImpl iDao = new InitiatingDaoImpl();
		String alter = request.getParameter("alter");
		if (alter != null) {
			request.setAttribute("initiatingnum", alter);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Alter.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("innn");
			System.out.println(request.getParameter("pair"));
			Map<String, String[]> params = request.getParameterMap();
			InitiatingBean initiatingBean = iDao.setInitiatingBean(params);
			iDao.updateInitiating(initiatingBean);
			RequestDispatcher rd = request.getRequestDispatcher("/view");
			rd.forward(request, response);
		}
	}

}
