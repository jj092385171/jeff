package T4_33.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import T4_33.bean.PostBean;
import T4_33.dao.PostDao;
import utils.DbUtils;

@WebServlet("/T4_33/servlet/newPostServlet")
public class newPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			PostBean bean = new PostBean();
			String title = request.getParameter("title"); //取得輸入的title
			bean.setTitle(title);
			String content = request.getParameter("content"); //取得輸入的content
			bean.setContent(content);
			String stringPicture = request.getParameter("picture"); //取得輸入的picture
			InputStream isPicture = null;
			if(stringPicture != null) {
				isPicture = new ByteArrayInputStream(stringPicture.getBytes()); //String要轉成inputStream
			}
			bean.setPicture(isPicture);
			String stringPeople = request.getParameter("people"); //取得輸入的people
			int people = 0;
			if(stringPeople != "") {
				people = Integer.parseInt(stringPeople);
			}
			bean.setPeople(people);
			String stringPrice = request.getParameter("price"); //取得輸入的price
			int price = 0;
			if(stringPrice != "") {
				price = Integer.parseInt(stringPrice);
			}
			bean.setPrice(price);
			String county = request.getParameter("county"); //取得輸入的county
			bean.setCounty(county);
			String stringStartDate = request.getParameter("startDate"); //取得輸入的startDate
			Date startDate = new Date(1970-01-01);
			if(stringStartDate != "") {
				startDate = date.parse(stringStartDate);
			}
			bean.setStartDate(startDate);
			String stringEndDate = request.getParameter("endDate"); //取得輸入的endDate
			Date endDate = new Date(1970-01-01);
			if(stringEndDate != "") {
				endDate = date.parse(stringEndDate);
			}
			bean.setEndDate(endDate);
			String stringScore = request.getParameter("score"); //取得輸入的score
			int score = 0;
			if(stringScore != "") {
				score = Integer.parseInt(stringScore);
			}
			bean.setScore(score);
			
			PostDao Dao = new PostDao(DbUtils.getConnection());
			int postId = Dao.insertPost(bean);
			
			request.setAttribute("postId", postId); //傳postId到showPostServlet
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
			rd.forward(request, response);
			
			return;
			
		} catch (IOException | ParseException | SQLException | ServletException e) {
			e.printStackTrace();
		}
		
	}

}
