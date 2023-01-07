package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.SiteDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.service.ImgService;

import util.HibernateUtils;


@MultipartConfig
@WebServlet("/InsertSiteByIDServlet.do")
public class InsertSiteByIDServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// 新增site
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		// 營位區名
		String siteName = request.getParameter("siteName");
		if (siteName == null || siteName.trim().length() == 0) {
			errorMsg.put("siteName", "必須輸入營區位名稱");
		}
		System.out.println(siteName);
		// 讀圖
		Part part = request.getPart("sitePictures");
		if (part.getSize() == 0) {
			errorMsg.put("sitePictures", "必須選擇圖片");
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
		} catch (NumberFormatException e1) {
			errorMsg.put("siteMoney", "請輸入數字");
		}
		String campID = request.getParameter("campID");

		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/InsertSiteByIDForm.jsp");
			rd.forward(request, response);
			return;
		}

		Site sb = new Site();
		sb.setSiteName(siteName);
		sb.setSitePictures(blob);
		sb.setTotalSites(Integer.valueOf(totalSites));
		sb.setSiteMoney(Integer.valueOf(siteMoney));
		sb.setCamp(session.get(Camp.class, Integer.valueOf(campID)));

		Serializable siteID = session.save(sb);

		SiteDao siteDao = new SiteDao(session);
		Site site = siteDao.findSiteByID((Integer) siteID);

		request.setAttribute("site", site);
		request.setAttribute("what", "新增");

		RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/InsertUpdateSiteSuccess.jsp");
		rd.forward(request, response);
		return;

	}

}
