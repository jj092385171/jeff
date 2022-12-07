package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;

import T4_24.Models.CampBean;


@MultipartConfig
@WebServlet("/T4_24/UpdateCampByIDServlet")
public class UpdateCampByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		//營地編號
		String campID = request.getParameter("campID");
		//營名
		String campName = request.getParameter("campName");
		//讀圖
		Part part = request.getPart("campPictures");
		InputStream is = part.getInputStream();
		Blob blob = Hibernate.createBlob(is);
		//簡介
		String discription = request.getParameter("discription");
		//標籤
		String[] tagIDs = request.getParameterValues("tagID");
		
		
		
		
	}

}
