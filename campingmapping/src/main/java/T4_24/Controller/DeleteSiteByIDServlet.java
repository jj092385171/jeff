package T4_24.Controller;

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
import T4_24.Dao.SiteDao;
import T4_24.Models.CampSiteCityTagsBean;


@WebServlet("/T4_24/DeleteSiteByIDServlet")
public class DeleteSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		SiteDao siteDao = new SiteDao();
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		String siteID = request.getParameter("siteID");
		
		if (siteID == null || siteID.trim().length() == 0) {
			errorMsg.put("siteID", "必須輸入營區位編號");
		}
		try {
			if(siteDao.findSiteBySiteID(Integer.valueOf(siteID)) == null) {
				errorMsg.put("siteID", "查無此營區位");
			}
		} catch (NumberFormatException e1) {
			errorMsg.put("siteID", "請輸入數字");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/deletePage.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		try {
			siteDao.deleteBySiteID(Integer.valueOf(siteID));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		session.setAttribute("ID","siteID: " + siteID + " 刪除成功");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/DeleteByIDSuccess.jsp"));
	}

}
