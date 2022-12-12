package T4_33.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_33.bean.PostBean;
import T4_33.dao.PostDao;
import utils.DbUtils;

@WebServlet("/T4_33/showReportPostServlet")
public class showReportPostServlet extends HttpServlet {
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
			
			PostDao postDao = new PostDao(DbUtils.getConnection()); // 送postId到資料庫
			List<PostBean> list = postDao.selectPostReport(); // 回傳隱藏貼文list
			
			request.setAttribute("postReportList", list); // 送list到showReportPost
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showReportPost.jsp");
			rd.forward(request, response);
			return;
		
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
