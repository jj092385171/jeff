package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampDao;
import T4_24.Dao.CityDao;
import T4_24.Models.CampBean;
import T4_24.Models.CityBean;


@WebServlet("/T4_24/QueryCampsByCityIDsServlet")
public class QueryCampsByCityIDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//透過cityIDs搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		CampDao campDao = new CampDao();
		CityDao cityDao = new CityDao();
		
		String[] cityIDs = request.getParameterValues("cityID");
		
		List<CampBean> campList = new ArrayList<CampBean>();	
		List<CityBean> cityList = new ArrayList<CityBean>();	
		
		for(String cityID : cityIDs) {
			try {
				List<CampBean> findCampsByCityID = campDao.findCampsByCityID( Integer.valueOf(cityID));
				campList.addAll(findCampsByCityID);
				
				cityList.add( cityDao.findCityNameByCityID(Integer.valueOf(cityID)) );
				
				
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		session.setAttribute("campList", campList);
		session.setAttribute("cityList", cityList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCityNameResult.jsp") ); 
		return;
				
				
	}

}
