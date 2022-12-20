package controller;

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

import T4_24.dao.CampDao;
import T4_24.model.Camp;
import T4_24.model.City;
import T4_24.model.Tag;
import T4_24.service.ImgService;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig
@WebServlet("/T4_24/InsertCampServlet")
public class InsertCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// 新增camp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CampDao campDao = new CampDao(session);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession();

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
		for (String tagID : tagIDs) {
			Tag tag = session.get(Tag.class, tagID);
			tagSet.add(tag);
		}

		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertPageServlet");
			rd.forward(request, response);
			return;
		}

		Camp cb = new Camp();
		cb.setCampName(campName);
		cb.setCity(session.get(City.class, cityID));
		cb.setLocation(location);
		cb.setCampPictures(blob);
		cb.setDescription(description);
		cb.setTags(tagSet);

		Serializable campID = session.save(cb);
		Camp camp = campDao.findCampByID((Integer) campID);

		httpSession.setAttribute("campID", campID.toString());
		httpSession.setAttribute("camp", camp);
		httpSession.setAttribute("what", "新增");

		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/InsertUpdateCampSuccess.jsp"));
		return;

	}

}
