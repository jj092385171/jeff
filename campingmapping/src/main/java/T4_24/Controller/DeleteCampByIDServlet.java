package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampDao;


@WebServlet("/T4_24/DeleteCampByIDServlet")
public class DeleteCampByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String campID = request.getParameter("campID");
		CampDao campDao = new CampDao();
		
		
		try {
			campDao.deletdByCampID(Integer.valueOf(campID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		session.setAttribute("campID", campID + " 刪除成功");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/DeleteByCampIDSuccess.jsp"));
	}

}
