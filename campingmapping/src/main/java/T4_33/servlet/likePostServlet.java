package T4_33.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.dao.PostDao;
import utils.DbUtils;

@WebServlet("/T4_33/likePostServlet")
public class likePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			int postId = Integer.parseInt(request.getParameter("postId")) ; //取得postId
			PostDao dao = new PostDao(DbUtils.getConnection()); //送postId到資料庫
			dao.likePost(postId); //喜歡貼文人數+1
			//--> 沒做判斷userId
			
			request.setAttribute("postId", postId); //送postId回showPostServlet
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
			rd.forward(request, response);
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}
	}

}
