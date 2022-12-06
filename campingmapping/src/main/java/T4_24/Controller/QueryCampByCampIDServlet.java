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
import T4_24.Dao.CityDao;
import T4_24.Models.CampBean;
import T4_24.Models.CityBean;


@WebServlet("/T4_24/QueryCampByCampIDServlet")
public class QueryCampByCampIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//透過campID搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		CampDao campDao = new CampDao();
		CityDao cityDao = new CityDao();
		
		String campID = request.getParameter("campID");
		
		CampBean campBean = null;
		CityBean cityBean = null;
		try {
			campBean = campDao.findCampByID(Integer.valueOf(campID));
			
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
			
		
		
		try {
			cityBean = cityDao.findCityNameByCityID( campBean.getCityID() );
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("campBean", campBean);
		session.setAttribute("cityBean", cityBean);
		
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCampIDResult.jsp") ); 
		return;
		
	}

}
