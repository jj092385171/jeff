package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
import T4_24.Dao.TagDao;
import T4_24.Dao.TagOfCampDao;
import T4_24.Models.CampBean;
import T4_24.Models.TagBean;


@MultipartConfig
@WebServlet("/T4_24/InsertCampServlet")
public class InsertCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		//營地名
		String campName = request.getParameter("campName");
		if(campName == null  ||  campName.trim().length() == 0) {
			errorMsg.put("campName", "必須輸入營地名稱");
		}
		//縣市
		String cityID = request.getParameter("cityID");
		
		//地址
		String location = request.getParameter("location");
		if(location == null  ||  location.trim().length() == 0) {
			errorMsg.put("location", "必須輸入地址");
		}	
		//讀圖
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
		if(is.read() == -1) {
			errorMsg.put("campPictures", "必須選擇圖片");
		}	
		com.mysql.cj.jdbc.Blob blob = (com.mysql.cj.jdbc.Blob) Hibernate.createBlob(is);
		
		//簡介
		String discription = request.getParameter("discription");
		//標籤
		String[] tagIDs = request.getParameterValues("tagID");
		
		
		//錯誤返回呼叫jsp
		if(!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertCamp");
			rd.forward(request, response);
			return;
			
		}
		
		CampBean cb = new CampBean(campName, Integer.valueOf(cityID), location, blob, discription);
		CampDao campDao = new CampDao();
		TagOfCampDao tagOfCampDao = new TagOfCampDao();
		
		try {
			BigDecimal campID = campDao.Add(cb);
			for(String tagID : tagIDs) {
				tagOfCampDao.Add( Integer.valueOf(tagID) ,campID.intValueExact() );
			}
			session.setAttribute("CampBean", cb);
			
			String contextPath = request.getContextPath();
			response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/InsertMemberSuccess.jsp") ); 
			return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
