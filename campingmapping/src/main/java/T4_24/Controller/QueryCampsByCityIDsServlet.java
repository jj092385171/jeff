package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Models.CampSiteCityTagsBean;


@WebServlet("/T4_24/QueryCampsByCityIDsServlet")
public class QueryCampsByCityIDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//透過cityIDs搜尋營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		
		String[] cityIDs = request.getParameterValues("cityID");
		if (cityIDs == null || cityIDs.length == 0) {
			errorMsg.put("cityIDs", "必須勾選縣市");
		}

		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/QueryPageServlet");
			rd.forward(request, response);
			return;
		}
		
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		List<CampSiteCityTagsBean> cctAllList = new ArrayList<CampSiteCityTagsBean>();
		
		for(String cityID : cityIDs) {
			try {
				List<CampSiteCityTagsBean> cctLIst = campPlusCityPlusTagsDao.findCampsByCityID( Integer.valueOf(cityID));
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
