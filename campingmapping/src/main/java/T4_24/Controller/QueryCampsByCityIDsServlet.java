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

import T4_24.Dao.CampPlusCityPlusTagsDao;
import T4_24.Models.CampPlusCityPlusTagsBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/QueryCampsByCityIDsServlet")
public class QueryCampsByCityIDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//透過cityIDs搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		
		String[] cityIDs = request.getParameterValues("cityID");
		System.out.println(cityIDs);
		
		CampPlusCityPlusTagsDao campPlusCityPlusTagsDao = new CampPlusCityPlusTagsDao();
	
		List<CampPlusCityPlusTagsBean> cctAllList = new ArrayList<CampPlusCityPlusTagsBean>();
		
		for(String cityID : cityIDs) {
			try {
				List<CampPlusCityPlusTagsBean> cctLIst = campPlusCityPlusTagsDao.findCampsByCityID( Integer.valueOf(cityID));
				cctAllList.addAll(cctLIst);
				
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("cctAllList", cctAllList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCityIDsResult.jsp") ); 
		return;
				
				
	}

}
