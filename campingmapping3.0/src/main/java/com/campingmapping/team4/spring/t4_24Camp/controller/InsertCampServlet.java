package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.service.ImgService;

import util.HibernateUtils;


@MultipartConfig
@WebServlet("/T4_24/InsertCampServlet")
public class InsertCampServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 新增camp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		// 存錯誤的map
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		// 存tags
		Set<Tag> tagSet = new HashSet<Tag>();

		// 營地名
		String campName = request.getParameter("campName");
		if (campName == null || campName.trim().length() == 0) {
			errorMsg.put("campName", "必須輸入營地名稱");
		}
		// 縣市
		String cityID = request.getParameter("cityID");
		if (cityID == null || cityID.trim().length() == 0) {
			errorMsg.put("cityID", "必須輸入縣市");
		}
		// 地址
		String location = request.getParameter("location");
		if (location == null || location.trim().length() == 0) {
			errorMsg.put("location", "必須輸入地址");
		}
		// 讀圖
		Part part = request.getPart("campPictures");
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

		// 簡介
		String description = request.getParameter("description");
		// 標籤
		String[] tagIDs = request.getParameterValues("tagID");
		if (tagIDs == null || tagIDs.length == 0) {
			errorMsg.put("tagIDs", "必須選擇標籤");
		}
		Tag tag = null;
		for (String tagID : tagIDs) {
			tag = session.get(Tag.class, Integer.valueOf(tagID));
			tagSet.add(tag);
		}

		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/InsertCampForm.jsp");
			rd.forward(request, response);
			return;
		}

		Camp cb = new Camp();
		cb.setCampName(campName);
		cb.setCity(session.get(City.class, Integer.valueOf(cityID)));
		cb.setLocation(location);
		cb.setCampPictures(blob);
		cb.setDescription(description);
		cb.setTags(tagSet);

		Serializable campID = session.save(cb);
		
		CampDao campDao = new CampDao(session);
		Camp camp = campDao.findCampByID((Integer) campID);

		httpSession.setAttribute("camp", camp);
		httpSession.setAttribute("what", "新增");

		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_24camp/admin/InsertUpdateCampSuccess.jsp"));
		return;

	}

}
