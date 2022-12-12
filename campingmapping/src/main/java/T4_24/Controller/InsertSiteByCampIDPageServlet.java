package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
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
import T4_24.Dao.CityDao;
import T4_24.Dao.TagDao;
import T4_24.Models.CampSiteCityTagsBean;
import T4_24.Models.CityBean;
import T4_24.Models.TagBean;


@WebServlet("/T4_24/InsertSiteByCampIDPageServlet")
public class InsertSiteByCampIDPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//展示父營地, 新增site頁面
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		CampSiteCityTagsDao campSiteCityTagsDao = new CampSiteCityTagsDao();
		CampSiteCityTagsBean bean = new CampSiteCityTagsBean();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		//營地編號
		String campID = request.getParameter("campID");
		if (campID == null || campID.trim().length() == 0) {
			errorMsg.put("campID", "必須輸入營地編號");
		}
//		try {
//			bean = campSiteCityTagsDao.findCampByID(Integer.valueOf(campID));
//			System.out.println(bean);
//			
//		} catch (NumberFormatException | SQLException e1) {
//			
//			e1.printStackTrace();
//		}
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertPageServlet");
			rd.forward(request, response);
			return;
		}

		
		CampSiteCityTagsDao campPlusCityDao = campSiteCityTagsDao;
		TagDao tagDao = new TagDao();
		CityDao cityDao = new CityDao();
		CampSiteCityTagsBean cctBean = null;
		List<TagBean> tagList = null;
		List<CityBean> cityList = null;
		
		try {
			//展示父營地
			cctBean = campPlusCityDao.findCampByID(Integer.valueOf(campID));
			tagList = tagDao.showAll();
			cityList = cityDao.showAll();
			
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	
		session.setAttribute("cctBean", cctBean);
		session.setAttribute("tagList", tagList);
		session.setAttribute("cityList", cityList);
		
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/InsertSiteByIDForm.jsp"));
		
		return;
		
	}

}
