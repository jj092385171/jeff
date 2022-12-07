package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampDao;
import T4_24.Dao.CampPlusCityDao;
import T4_24.Dao.CityDao;
import T4_24.Dao.TagPlusCampDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityBean;
import T4_24.Models.CityBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/QueryCampByCampIDServlet")
public class QueryCampByCampIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//透過campID搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		CampPlusCityDao campPlusCityDao = new CampPlusCityDao();
		TagPlusCampDao tagPlusCampDao = new TagPlusCampDao();
		
		String campID = request.getParameter("campID");
		CampPlusCityBean cpcBean = null;
		List<TagPlusCampBean> tagList = null;
		
		try {
			cpcBean = campPlusCityDao.findCampByID(Integer.valueOf(campID));
			tagList = tagPlusCampDao.findTagNameByCampID(Integer.valueOf(campID));
			cpcBean.setTagList(tagList);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		session.setAttribute("cpcBean", cpcBean);
		
	
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCampIDResult.jsp") ); 
		return;
		
	}

}
