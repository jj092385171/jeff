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

import T4_24.Dao.CampDao;
import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Dao.TagOfCampDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampSiteCityTagsBean;

@MultipartConfig
@WebServlet("/T4_24/InsertCampServlet")
public class InsertCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		CampDao campDao = new CampDao();
		TagOfCampDao tagOfCampDao = new TagOfCampDao();
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);

		// 營地名
		String campName = request.getParameter("campName");
		if (campName == null || campName.trim().length() == 0) {
			errorMsg.put("campName", "必須輸入營地名稱");
		}
		// 縣市
		String cityID = request.getParameter("cityID");
		// 地址
		String location = request.getParameter("location");
		if (location == null || location.trim().length() == 0) {
			errorMsg.put("location", "必須輸入地址");
		}
		// 讀圖
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
		if (is.read() == -1) {
			errorMsg.put("campPictures", "必須選擇圖片");
		}
		Blob blob = Hibernate.createBlob(is);
		// 簡介
		String discription = request.getParameter("discription");
		// 標籤
		String[] tagIDs = request.getParameterValues("tagID");

		// 錯誤返回呼叫jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertCampForm.jsp");
			rd.forward(request, response);
			return;
		}

		CampBean cb = new CampBean(campName, Integer.valueOf(cityID), location, blob, discription);

		try {
			// 新增到camp回傳campID
			BigDecimal campID = campDao.AddCamp(cb);

			// 利用campID和tagID新增到營地的標籤
			for (String tagID : tagIDs) {
				tagOfCampDao.Add(Integer.valueOf(tagID), campID.intValueExact());
			}
			
			CampSiteCityTagsBean cctBean = campPlusCityPlusTagsDao.findCampByID(campID.intValueExact());
			
			session.setAttribute("campID", campID.toString());
			session.setAttribute("cctBean", cctBean);
			session.setAttribute("what", "新增");

			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/T4_24/InsertUpdateCampSuccess.jsp"));
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
