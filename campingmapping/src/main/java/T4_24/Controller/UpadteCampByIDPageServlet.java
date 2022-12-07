package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampPlusCityDao;
import T4_24.Dao.CityDao;
import T4_24.Dao.TagDao;
import T4_24.Dao.TagPlusCampDao;
import T4_24.Models.CampPlusCityBean;
import T4_24.Models.CityBean;
import T4_24.Models.TagBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/UpadteCampByIDPageServlet")
public class UpadteCampByIDPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String campID = request.getParameter("campID");
		
		CampPlusCityDao campPlusCityDao = new CampPlusCityDao();
		TagDao tagDao = new TagDao();
		CityDao cityDao = new CityDao();
		CampPlusCityBean cpcBean = null;
		List<TagBean> tagList = null;
		List<CityBean> cityList = null;
		
		try {
			cpcBean = campPlusCityDao.findCampByID(Integer.valueOf(campID));
			tagList = tagDao.showAll();
			cityList = cityDao.showAll();
			
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	
		session.setAttribute("cpcBean", cpcBean);
		session.setAttribute("tagList", tagList);
		session.setAttribute("cityList", cityList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/UpdateCampByIDForm.jsp"));
		
		return;
		
	}

}
