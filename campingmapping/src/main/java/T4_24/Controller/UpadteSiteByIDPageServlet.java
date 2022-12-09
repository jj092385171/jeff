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

import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Dao.CityDao;
import T4_24.Dao.SiteDao;
import T4_24.Dao.TagDao;
import T4_24.Models.CampSiteCityTagsBean;
import T4_24.Models.CityBean;
import T4_24.Models.SiteBean;
import T4_24.Models.TagBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/UpadteSiteByIDPageServlet")
public class UpadteSiteByIDPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SiteDao siteDao = new SiteDao();
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String campID = request.getParameter("campID");
		List<SiteBean> siteList = null;
		
		try {
			siteList = siteDao.findSitesByCampID(Integer.valueOf(campID));
			
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("siteList", siteList);	
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/UpdateSiteByIDForm.jsp"));
		return;
		
	}

}
