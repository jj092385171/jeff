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
import T4_24.Dao.SiteDao;


@WebServlet("/T4_24/DeleteSiteByIDServlet")
public class DeleteSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String siteID = request.getParameter("siteID");
		SiteDao siteDao = new SiteDao();
		
		try {
			siteDao.deleteBySiteID(Integer.valueOf(siteID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		session.setAttribute("ID","siteID: " + siteID + " 刪除成功");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/DeleteByIDSuccess.jsp"));
	}

}
