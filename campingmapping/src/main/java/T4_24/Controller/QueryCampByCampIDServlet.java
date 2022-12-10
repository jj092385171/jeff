package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Models.CampSiteCityTagsBean;


@WebServlet("/T4_24/QueryCampByCampIDServlet")
public class QueryCampByCampIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//透過campID搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		
		String campID = request.getParameter("campID");
		CampSiteCityTagsBean csctBean = new CampSiteCityTagsBean();
		
		try {
			csctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		session.setAttribute("csctBean", csctBean);
		
	
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCampIDResult.jsp") ); 
		return;
		
	}

}
