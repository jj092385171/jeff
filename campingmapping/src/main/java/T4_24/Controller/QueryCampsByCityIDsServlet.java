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
import T4_24.Dao.CampPlusCityDao;
import T4_24.Dao.CityDao;
import T4_24.Dao.TagPlusCampDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityBean;
import T4_24.Models.CityBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/QueryCampsByCityIDsServlet")
public class QueryCampsByCityIDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//透過cityIDs搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		CampPlusCityDao campPlusCityDao = new CampPlusCityDao();
		TagPlusCampDao tagPlusCampDao = new TagPlusCampDao();
		
		String[] cityIDs = request.getParameterValues("cityID");
		List<CampPlusCityBean> cpcList = new ArrayList<CampPlusCityBean>();
		List<TagPlusCampBean> tagList = new ArrayList<>();
		
		for(String cityID : cityIDs) {
			try {
				List<CampPlusCityBean> findCampsByCityID = campPlusCityDao.findCampsByCityID( Integer.valueOf(cityID));
				cpcList.addAll(findCampsByCityID);
				
				
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		for(CampPlusCityBean cpcBean : cpcList) {
			try {
				tagList = tagPlusCampDao.findTagNameByCampID(cpcBean.getCampID());
				cpcBean.setTagList(tagList);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("cpcList", cpcList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCityNameResult.jsp") ); 
		return;
				
				
	}

}
