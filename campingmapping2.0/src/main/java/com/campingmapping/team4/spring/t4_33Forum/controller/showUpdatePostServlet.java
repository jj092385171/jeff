package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

import util.HibernateUtils;

@WebServlet("/T4_33/showUpdatePostServlet")
public class showUpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			Post post = new Post();
			post.setPostId(Integer.parseInt(request.getParameter("postId"))) ; //取得postId
			PostService postService = new PostService(session);	//送postId到資料庫取貼文內容	
			Post postResult = postService.selectSinglePost(post);
			
			httpSession.setAttribute("title", postResult.getTitle()); //傳送之前填寫的title
			httpSession.setAttribute("content", postResult.getContent()); //傳送之前填寫的content
//			if(postResult.getPicture() != null) { //傳送之前上傳的picture
//				request.setAttribute("picture", postResult.getPicture()); //--> 顯示圖片還沒做！！！！！！！！！！！！！！！！！！！！！
//			}
			int people = 0; //傳送之前選定的people
			if(postResult.getPeople() != 0) { 
				people = postResult.getPeople();
			}
			httpSession.setAttribute("people", people);
			if(postResult.getPrice() != 0) { //傳送之前填寫的price
				httpSession.setAttribute("price", postResult.getPrice());
			}
			if(postResult.getCounty() != null) { //傳送之前選定的county
				httpSession.setAttribute("county", postResult.getCounty());
			}
			if(postResult.getStartDate() != null) { //傳送之前選定的startDate
				httpSession.setAttribute("startDate", date.format(postResult.getStartDate())); //--> utilDate轉成String
			}
			if(postResult.getEndDate() != null) { //傳送之前選定的endDate
				httpSession.setAttribute("endDate", date.format(postResult.getEndDate())); //--> utilDate轉成String
			}		
			int score = 0; //傳送之前選定的score
			if(postResult.getScore() != 0) { 
				score = postResult.getScore();
			}
			httpSession.setAttribute("score", score);
			
			httpSession.setAttribute("postId", post.getPostId()); //送postId到updatePost
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/updatePost.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/guest/updatePost.jsp"));
			return;
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
