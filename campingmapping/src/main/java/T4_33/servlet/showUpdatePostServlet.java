package T4_33.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.bean.PostBean;
import T4_33.dao.PostDao;
import utils.DbUtils;

@WebServlet("/T4_33/showUpdatePostServlet")
public class showUpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			int postId = Integer.parseInt(request.getParameter("postId")) ; //取得postId
			PostDao dao = new PostDao(DbUtils.getConnection());	//送postId到資料庫取貼文內容	
			PostBean bean = dao.showPost(postId); //回傳bean
			
			request.setAttribute("title", bean.getTitle()); //傳送之前填寫的title
			request.setAttribute("content", bean.getContent()); //傳送之前填寫的content
			if(bean.getPicture() != null) { //傳送之前上傳的picture
				request.setAttribute("picture", bean.getPicture()); //--> 顯示圖片還沒做！！！！！！！！！！！！！！！！！！！！！
			}
			int people = 0; //傳送之前選定的people
			if(bean.getPeople() != 0) { 
				people = bean.getPeople();
			}
			request.setAttribute("people", people);
			if(bean.getPrice() != 0) { //傳送之前填寫的price
				request.setAttribute("price", bean.getPrice());
			}
			if(bean.getCounty() != null) { //傳送之前選定的county
				request.setAttribute("county", bean.getCounty());
			}
			if(bean.getStartDate() != null) { //傳送之前選定的startDate
				request.setAttribute("startDate", date.format(bean.getStartDate())); //--> utilDate轉成String
			}
			if(bean.getEndDate() != null) { //傳送之前選定的endDate
				request.setAttribute("endDate", date.format(bean.getEndDate())); //--> utilDate轉成String
			}		
			int score = 0; //傳送之前選定的score
			if(bean.getScore() != 0) { 
				score = bean.getScore();
			}
			request.setAttribute("score", score);
			
			request.setAttribute("postId", postId); //送postId到updatePost
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/updatePost.jsp");
			rd.forward(request, response);
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}
	}
}
