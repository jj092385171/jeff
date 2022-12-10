package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

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
@WebServlet("/T4_24/UpdateSiteByIDServlet")
public class UpdateSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		SiteDao siteDao = new SiteDao();
		
		//新值
		//營區位編號
		String siteID = request.getParameter("siteID");	
		//舊值
		SiteBean siteBean = new SiteBean();
		try {
			siteBean = siteDao.findSiteBySiteID(Integer.valueOf(siteID));
			
		} catch (NumberFormatException | SQLException e1) {
			e1.printStackTrace();
		}
	
		//營區位名
		String siteName = request.getParameter("siteName");
		//讀圖
		Part part = request.getPart("sitePictures");
		InputStream is = part.getInputStream();
		Blob blob = Hibernate.createBlob(is);
		// 總營位
		String totalSites = request.getParameter("totalSites");
		// 營位金額
		String siteMoney = request.getParameter("siteMoney");
		
		try {
			siteDao.updateBySiteID(siteName, blob, Integer.valueOf(totalSites), Integer.valueOf(siteMoney), Integer.valueOf(siteID));
			//新值
			siteBean = siteDao.findSiteBySiteID(Integer.valueOf(siteID));
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("siteBean", siteBean);
		session.setAttribute("what", "更新");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL( contextPath + "/T4_24/InsertUpdateSiteSuccess.jsp" )); 
		return;
		
	}

}
