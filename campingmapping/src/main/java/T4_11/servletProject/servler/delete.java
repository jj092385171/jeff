package T4_11.servletProject.servler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_11.servletProject.dao.InitiatingDaoImpl;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("delete");
		InitiatingDaoImpl iDao = new InitiatingDaoImpl();
		iDao.deleteInitiating(Integer.valueOf(num));
		
		RequestDispatcher rd = request.getRequestDispatcher("/view");
		rd.forward(request, response);
	}

}
