package T4_33.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.dao.DiscussionDao;
import utils.DbUtils;

@WebServlet("/T4_33/servlet/newDiscussionServlet")
public class newDiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String stringPicture = request.getParameter("picture");
			//String要轉成inputStream
			String stringPeople = request.getParameter("people");
			int people = Integer.parseInt(stringPeople);
			String stringPrice = request.getParameter("price");
			int price = Integer.parseInt(stringPrice);
			String county = request.getParameter("county");
			String stringStartDate = request.getParameter("startDate");
			Date utilStartDate = date.parse(stringStartDate);
			java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
			String stringEndDate = request.getParameter("endDate");
			Date utilEndDate = date.parse(stringEndDate);
			java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());
			String score = request.getParameter("price");
			
			d.insertPost(1, title, content, null, null, null, county, stringStartDate, stringEndDate, null);
			
			
			request.setAttribute("title", title);
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/discussionFirst.jsp");
			rd.forward(request, response);
			return;
			
		} catch (IOException | ServletException | ParseException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
