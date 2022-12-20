package T4_33.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.bean.PostCommentBean;
import T4_33.dao.PostCommentDao;
import utils.DbUtils;

@WebServlet("/T4_33/newPostCommentServlet")
public class newPostCommentServlet extends HttpServlet {
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
			PostCommentBean bean = new PostCommentBean(); 
			
			int postId = Integer.parseInt(request.getParameter("postId")); //取得postId
			bean.setPostId(postId);
			
			bean.setUserId(1);//取得userId
			
			String postComment = request.getParameter("postComment"); //取得輸入的postComment
			bean.setPostComment(postComment);
			
			PostCommentDao dao = new PostCommentDao(DbUtils.getConnection()); //送到資料庫建立postComment
			dao.insertPostComment(bean);
			
			request.setAttribute("postId", postId); //傳postId到showPostServlet			
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
