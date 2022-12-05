package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampDao;
import T4_24.Models.CampBean;


@WebServlet("/T4_24/QueryCampServlet")
public class QueryCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//部分搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		CampDao campDao = new CampDao();
		
		String[] cityIDs = request.getParameterValues("cityID");
		
		for(String cityID : cityIDs) {
			try {
				List<CampBean> campList = campDao.findByCityID( Integer.valueOf(cityID) );
				session.setAttribute("campList", campList);
				
				String contextPath = request.getContextPath();
				response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCityNameResult.jsp") ); 
				return;
				
				
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
