package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Models.CampSiteCityTagsBean;


@WebServlet("/T4_24/QueryCampByCampIDServlet")
public class QueryCampByCampIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//透過campID搜尋
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		CampSiteCityTagsBean csctBean = new CampSiteCityTagsBean();
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		
		String campID = request.getParameter("campID");
		if (campID == null || campID.trim().length() == 0) {
			errorMsg.put("campID", "必須輸入營地編號");
		}
		try {
			if(campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID)) == null) {
				errorMsg.put("campID", "查無此營地");
			}
		} catch (NumberFormatException e1) {
			errorMsg.put("campID", "請輸入數字");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/QueryPageServlet");
			rd.forward(request, response);
			return;
		}
		
		
		try {
			csctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		session.setAttribute("csctBean", csctBean);
		
	
		String contextPath = request.getContextPath();
		response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/QueryByCampIDResult.jsp") ); 
		return;
		
	}

}
