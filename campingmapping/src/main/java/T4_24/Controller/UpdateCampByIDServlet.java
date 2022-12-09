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

import T4_24.Dao.CampDao;
import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Dao.TagOfCampDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampSiteCityTagsBean;


@MultipartConfig
@WebServlet("/T4_24/UpdateCampByIDServlet")
public class UpdateCampByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		TagOfCampDao tagOfCampDao = new TagOfCampDao();
		CampDao campDao = new CampDao();
		CampSiteCityTagsBean cctBean = new CampSiteCityTagsBean();
		
		
		//新值
		//營地編號
		String campID = request.getParameter("campID");
		
		try {
			//舊值
			cctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			//刪除舊值 營地的標籤
			tagOfCampDao.deletdByCampID(Integer.valueOf(campID));
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		//營地名
		String campName = request.getParameter("campName");
		// 縣市
		String cityID = request.getParameter("cityID");
		// 地址
		String location = request.getParameter("location");
		//讀圖
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
		Blob blob = Hibernate.createBlob(is);
		//簡介
		String discription = request.getParameter("discription");
		//標籤
		String[] tagIDs = request.getParameterValues("tagID");
		
		try {
			campDao.updateByCampID(campName, Integer.valueOf(cityID), location, blob, discription, Integer.valueOf(campID));
			
			// 利用campID和tagID新增到營地的標籤
			for (String tagID : tagIDs) {
				tagOfCampDao.Add(Integer.valueOf(tagID), Integer.valueOf(campID));
			}
			
			cctBean = campPlusCityPlusTagsDao.findCampByID(Integer.valueOf(campID));
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("cctBean", cctBean);
		session.setAttribute("what", "更新");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL( contextPath + "/T4_24/InsertUpdateCampSuccess.jsp" )); 
		return;
		
	}

}
