package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampPlusCityPlusTagsDao;
import T4_24.Models.CampPlusCityPlusTagsBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/QueryCampByCampIDServlet")
public class QueryCampByCampIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//透過campID搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		CampPlusCityPlusTagsDao campPlusCityPlusTagsDao = new CampPlusCityPlusTagsDao();
		
		String campID = request.getParameter("campID");
		CampPlusCityPlusTagsBean cctBean = null;
		
		try {
			cctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		session.setAttribute("cctBean", cctBean);
		
	
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCampIDResult.jsp") ); 
		return;
		
	}

}
