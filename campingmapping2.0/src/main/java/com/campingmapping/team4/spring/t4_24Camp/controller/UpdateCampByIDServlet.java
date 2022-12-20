package controller;

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

import org.hibernate.Hibernate;

import T4_24.Dao.CampDao;
import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Dao.TagOfCampDao;
import T4_24.Models.CampSiteCityTagsBean;


@MultipartConfig
@WebServlet("/T4_24/UpdateCampByIDServlet")
public class UpdateCampByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//存錯誤的map
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		TagOfCampDao tagOfCampDao = new TagOfCampDao();
		CampDao campDao = new CampDao();
		CampSiteCityTagsBean csctBean = new CampSiteCityTagsBean();
		
		
		//新值
		//營地編號
		String campID = request.getParameter("campID");
		
		//營地名
		String campName = request.getParameter("campName");
		if (campName == null || campName.trim().length() == 0) {
			errorMsg.put("campName", "必須輸入營地名稱");
		}
		// 縣市
		String cityID = request.getParameter("cityID");
		if (cityID == null || cityID.trim().length() == 0) {
			errorMsg.put("cityID", "必須選擇縣市");
		}
		// 地址
		String location = request.getParameter("location");
		if (location == null || location.trim().length() == 0) {
			errorMsg.put("location", "必須輸入地址");
		}
		//讀圖
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
		Blob blob = Hibernate.createBlob(is);
		if (blob == null) {
			errorMsg.put("campPictures", "必須選擇圖片");
		}
		//簡介
		String discription = request.getParameter("discription");
		if (discription == null || discription.trim().length() == 0) {
			errorMsg.put("discription", "必須輸入描述");
		}
		//標籤
		String[] tagIDs = request.getParameterValues("tagID");
		if (tagIDs == null || tagIDs.length == 0) {
			errorMsg.put("tagIDs", "必須選擇標籤");
		}
		
		
		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/UpdateCampByIDForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		try {
			//執行更新
			campDao.updateByCampID(campName, Integer.valueOf(cityID), location, blob, discription, Integer.valueOf(campID));
			
			//刪除舊值 營地的標籤
			csctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			tagOfCampDao.deletdByCampID(Integer.valueOf(campID));
			//新增新標籤
			for (String tagID : tagIDs) {
				tagOfCampDao.Add(Integer.valueOf(tagID), Integer.valueOf(campID));
			}
			
			//更新後
			csctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("csctBean", csctBean);
		session.setAttribute("what", "更新");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL( contextPath + "/T4_24/InsertUpdateCampSuccess.jsp" )); 
		return;
		
	}

}
