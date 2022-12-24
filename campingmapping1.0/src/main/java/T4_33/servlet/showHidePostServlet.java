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

@WebServlet("/T4_33/showHidePostServlet")
public class showHidePostServlet extends HttpServlet {
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
			PostDao dao = new PostDao(DbUtils.getConnection()); // 送postId到資料庫
			List<PostBean> list = dao.selectPostHide(); // 回傳隱藏貼文list
			
			request.setAttribute("postHideList", list); // 送list到showHidePost
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showHidePost.jsp");
			rd.forward(request, response);
			DbUtils.commit();
			return;
		
		} catch (IOException | ServletException | SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		
		
	}

}