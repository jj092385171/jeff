package T4_33.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.dao.PostCommentDao;
import utils.DbUtils;

@WebServlet("/T4_33/hidePostCommentServlet")
public class hidePostCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			DbUtils.begin();
			request.setCharacterEncoding("UTF-8");
			int postId = Integer.parseInt(request.getParameter("postId")) ; //取得postId
			int postCommentId = Integer.parseInt(request.getParameter("postCommentId")) ; //取得postCommentId
			PostCommentDao dao = new PostCommentDao(DbUtils.getConnection()); //送postCommentId到資料庫
			String hidePostCommentResult = dao.hidePostComment(postCommentId); //回傳隱藏結果
						
			request.setAttribute("postId", postId); //送postId出去
			request.setAttribute("postCommentId", postCommentId); //送postCommentId出去
			request.setAttribute("hidePostCommentResult", hidePostCommentResult); //顯示隱藏留言結果
			//沒有顯示隱藏留言結果
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
			rd.forward(request, response);
			DbUtils.commit();
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

}
