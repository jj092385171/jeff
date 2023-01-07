package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

import java.io.IOException;
import java.io.InputStream;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.SiteDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.service.ImgService;

import util.HibernateUtils;




@MultipartConfig
@WebServlet("/T4_24/UpdateSiteByIDServlet")
public class UpdateSiteByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//更新頁面, site
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		
		//新值
		//營區位編號
		String siteID = request.getParameter("siteID");
	
		//營區位名
		String siteName = request.getParameter("siteName");
		if (siteName == null || siteName.trim().length() == 0) {
			errorMsg.put("siteName", "必須輸入營區位名");
		}
		//讀圖
		Part part = request.getPart("sitePictures");
		if (part.getSize() == 0) {
			errorMsg.put("campPictures", "必須選擇圖片");
		}
		InputStream is = part.getInputStream();
		long size = part.getSize();
		Blob blob = null;
		try {
			blob = ImgService.fileToBlob(is, size);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 總營位
		String totalSites = request.getParameter("totalSites");
		try {
			if (totalSites == null || totalSites.trim().length() == 0) {
				errorMsg.put("totalSites", "必須輸入總營位");
			}
		} catch (NumberFormatException e) {
			errorMsg.put("totalSites", "請輸入數字");
		}
		// 營位金額
		String siteMoney = request.getParameter("siteMoney");
		try {
			if (siteMoney == null || siteMoney.trim().length() == 0) {
				errorMsg.put("siteMoney", "必須輸入營位金額");
			}
		} catch (NumberFormatException e) {
			errorMsg.put("siteMoney", "請輸入數字");
		}
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/UpdateSiteByIDForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		SiteDao siteDao = new SiteDao(session);
		Site site = siteDao.updateBySiteID(Integer.valueOf(siteID), siteName, blob, Integer.valueOf(totalSites), Integer.valueOf(siteMoney));
			
		
		httpSession.setAttribute("site", site);
		httpSession.setAttribute("what", "更新");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL( contextPath + "/t4_24camp/admin/InsertUpdateSiteSuccess.jsp" )); 
		return;
		
	}

}
