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

import T4_33.bean.DiscussionBean;
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
			DiscussionBean b = new DiscussionBean();

			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			b.setTitle(title);
			String content = request.getParameter("content");
			b.setContent(content);
			String stringPicture = request.getParameter("picture");
			b.setPicture(null);
			//String要轉成inputStream
			int People = Integer.parseInt(request.getParameter("people"));
			b.setPeople(People);
			String pricejsp = request.getParameter("price");
			int price;
			if( pricejsp != "") {
				price = Integer.parseInt(pricejsp);
				
			}else {
				
				price = 0;
			}
			
			b.setPrice(price);
			String county = request.getParameter("county");
			b.setCounty(county);
			Date StartDate = date.parse(request.getParameter("startDate"));
			b.setStartDate(StartDate);
//			Date utilStartDate = date.parse(stringStartDate);
//			java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
			Date  EndDate = date.parse(request.getParameter("endDate"));
			b.setEndDate(EndDate);
//			Date utilEndDate = date.parse(stringEndDate);
//			java.sql.Date endDate = new java.sql.Date(utilEndDate.getTime());
			int score =  Integer.parseInt(request.getParameter("score"));
			b.setScore(score);
			DiscussionDao Dao = new DiscussionDao(DbUtils.getConnection());
//			Dao.insertPost(1, title, content, null, people, price, county, stringStartDate, stringEndDate, score);
			Dao.insertPost2(b);
			
			
			request.setAttribute("title", title);
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/discussionFirst.jsp");
			rd.forward(request, response);
			return;
			
		} catch (IOException | ServletException | ParseException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
