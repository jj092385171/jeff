package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostCommentService;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

import util.HibernateUtils;

@WebServlet("/T4_33/showPostServlet")
public class showPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			request.setCharacterEncoding("UTF-8");
			HttpSession httpSession = request.getSession();
			
			Post post = new Post();
			//取得postId
//			int postId = 0; 
			if(request.getParameter("postId") != null) {
//				postId = Integer.parseInt(request.getParameter("postId"));
				post.setPostId(Integer.parseInt(request.getParameter("postId")));
			}else {
//				postId = Integer.parseInt(request.getAttribute("postId").toString());
				post.setPostId(Integer.parseInt(request.getAttribute("postId").toString()));
			}	
			
			PostService postService = new PostService(session); //送postId到資料庫取貼文內容
			Post resultPost = postService.selectSinglePost(post); //回傳post
			
			PostCommentService postCommentService = new PostCommentService(); //送postId到資料庫取留言
			List<PostComment> comList = postCommentService.selectPostComment(post); //回傳commentList
			
			httpSession.setAttribute("title", resultPost.getTitle()); //顯示title
			httpSession.setAttribute("content", resultPost.getContent()); //顯示content
//			if(resultPost.getPicture() != null) { //顯示picture
//				request.setAttribute("picture", resultPost.getPicture()); //--> 顯示圖片還沒做！！！！！！！！！！！！！！！！！！！！！
//			}
			if(resultPost.getPeople() != 0) { //顯示people
				httpSession.setAttribute("people", resultPost.getPeople());
			}
			if(resultPost.getPrice() != 0) { //顯示price
				httpSession.setAttribute("price", resultPost.getPrice());
			}
			if(resultPost.getCounty() != null) { //顯示county
				String[] countyChinese = {"台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
									"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"};
				String[] countyValue = {"TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
									"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"};
				String county = null;
				for(int i=0; i<countyValue.length; i++) {
					if(resultPost.getCounty().equals(countyValue[i])) {
						county = countyChinese[i];
					}
				}
				httpSession.setAttribute("county", county);
			}
			if(resultPost.getStartDate() != null) { //顯示startDate
				httpSession.setAttribute("startDate", date.format(resultPost.getStartDate())); //--> utilDate轉成String
			}
			if(resultPost.getEndDate() != null) { //顯示endDate
				httpSession.setAttribute("endDate", date.format(resultPost.getEndDate())); //--> utilDate轉成String
			}
			if(resultPost.getScore() != 0) { //顯示score
				httpSession.setAttribute("score", resultPost.getScore());
			}
			httpSession.setAttribute("releaseDate", dateTime.format(resultPost.getReleaseDate())); //顯示releaseDate
			httpSession.setAttribute("userLike", resultPost.getUserLike()); //顯示userLike
			httpSession.setAttribute("userUnlike", resultPost.getUserUnlike()); //顯示userUnlike
			
			httpSession.setAttribute("postId", post.getPostId()); //送postId到showPost
			httpSession.setAttribute("comList", comList); //送comList到showPost
			
//			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPost.jsp");
//			rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/t4_33forum/guest/showPost.jsp"));
			return;
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
