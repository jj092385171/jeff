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

@WebServlet("/T4_33/newPostServlet")
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
//			String stringPicture = request.getParameter("picture"); //取得輸入的picture
//			InputStream isPicture = null;
//			if(stringPicture != "") {
//				isPicture = new ByteArrayInputStream(stringPicture.getBytes()); //--> String轉成inputStream
//			}
//			bean.setPicture(isPicture);
			
			
			String picture = request.getParameter("picture"); //取得輸入的picture
			if(picture != "") {
				picture = "/imgs/" + picture; //
			}
			bean.setPicture(picture);
			System.out.println(picture);
			
			
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
			Date startDate = null;
			if(stringStartDate != "") {
				startDate = date.parse(stringStartDate); //--> String轉成utilDate
			}
			bean.setStartDate(startDate);
			String stringEndDate = request.getParameter("endDate"); //取得輸入的endDate
			Date endDate = null;
			if(stringEndDate != "") {
				endDate = date.parse(stringEndDate); //--> String轉成utilDate
			}
			bean.setEndDate(endDate);
			String stringScore = request.getParameter("score"); //取得輸入的score
			int score = 0;
			if(stringScore != "") {
				score = Integer.parseInt(stringScore);
			}
			bean.setScore(score);
			
			PostDao dao = new PostDao(DbUtils.getConnection()); //送到資料庫建立post
			int postId = dao.insertPost(bean); //回傳建立的postId
			
			request.setAttribute("postId", postId); //傳postId到showPostServlet
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
			rd.forward(request, response);
			return;
			
		} catch (IOException | ParseException | SQLException | ServletException e) {
			e.printStackTrace();
		}
		
	}

}
