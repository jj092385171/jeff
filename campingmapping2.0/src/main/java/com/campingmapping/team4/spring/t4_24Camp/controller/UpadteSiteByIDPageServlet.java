package controller;

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

import T4_24.Dao.SiteDao;
import T4_24.Models.SiteBean;


@WebServlet("/T4_24/UpadteSiteByIDPageServlet")
public class UpadteSiteByIDPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//更新頁面, site ,顯示父營地
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SiteDao siteDao = new SiteDao();
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
				
		//營地編號
		String campIDSite = request.getParameter("campIDSite");
		if (campIDSite == null || campIDSite.trim().length() == 0) {
			errorMsg.put("campIDSite", "必須輸入營地編號");
		}
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/UpdatePage.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		List<SiteBean> siteList = null;
		
		try {
			siteList = siteDao.findSitesByCampID(Integer.valueOf(campIDSite));
			
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("siteList", siteList);	
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/UpdateSiteByIDForm.jsp"));
		return;
		
	}

}
