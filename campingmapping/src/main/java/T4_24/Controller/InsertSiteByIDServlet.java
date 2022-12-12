package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;

import T4_24.Dao.SiteDao;
import T4_24.Models.SiteBean;


@MultipartConfig
@WebServlet("/T4_24/InsertSiteByIDServlet")
public class InsertSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//新增site
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SiteDao siteDao = new SiteDao();
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		// 營位區名
		String siteName = request.getParameter("siteName");
		if (siteName == null || siteName.trim().length() == 0) {
			errorMsg.put("siteName", "必須輸入營區位名稱");
		}
		// 讀圖
//		Part part = request.getPart("sitePictures");
//		InputStream is = part.getInputStream();
//		if (is.read() == -1) {
//			errorMsg.put("sitePictures", "必須選擇圖片");
//		}
//		Blob blob = Hibernate.createBlob(is);
		// 總營位
		String totalSites = request.getParameter("totalSites");
		if (totalSites == null || totalSites.trim().length() == 0) {
			errorMsg.put("totalSites", "必須輸入總營位");
		}
		// 營位金額
		String siteMoney = request.getParameter("siteMoney");
		if (siteMoney == null || siteMoney.trim().length() == 0) {
			errorMsg.put("siteMoney", "必須輸入營位金額");
		}
		String campID = request.getParameter("campID");
		

		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertSiteByIDForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		SiteBean siteBean = new SiteBean(siteName, Integer.valueOf(totalSites), Integer.valueOf(siteMoney), Integer.valueOf(campID));
		try {
			BigDecimal siteID = siteDao.AddSite(siteBean);
			siteBean = siteDao.findSiteBySiteID(siteID.intValueExact());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("siteBean", siteBean);
		session.setAttribute("what", "新增");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/InsertUpdateSiteSuccess.jsp"));
		return;
		
	}

}
