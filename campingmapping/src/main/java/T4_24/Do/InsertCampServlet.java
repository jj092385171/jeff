package T4_24.Do;

import java.io.IOException;
import java.io.InputStream;
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

import T4_24.Models.CampBean;


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
		String city = request.getParameter("city");
		if(city == null  ||  city.trim().length() == 0) {
			errorMsg.put("city", "必須輸入縣市");
		}
		//地址
		String location = request.getParameter("location");
		if(location == null  ||  location.trim().length() == 0) {
			errorMsg.put("location", "必須輸入地址");
		}	
		//讀圖
//		String campPictures = request.getParameter("campPictures");
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
//		byte[] pic = new byte[is.available()];
//		is.read(pic);
		//簡介
		String discription = request.getParameter("discription");
		
		//錯誤返回呼叫jsp
		if(! errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertCampForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		CampBean cb = new CampBean(campName, city, location, is, discription);
		CampDao campDao = new CampDao();
		try {
			campDao.Add(cb);
			session.setAttribute("CampBean", cb);
			
			String contextPath = request.getContextPath();
			response.sendRedirect( response.encodeRedirectURL(contextPath + "/T4_24/InsertMemberSuccess.jsp") ); 
			return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
