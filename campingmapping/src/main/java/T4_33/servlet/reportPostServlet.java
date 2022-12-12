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

@WebServlet("/T4_33/reportPostServlet")
public class reportPostServlet extends HttpServlet {
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
			int postId = Integer.parseInt(request.getParameter("postId"));//取得postId
			PostDao dao = new PostDao(DbUtils.getConnection()); //送postId到資料庫
			String reportResult = dao.reportPost(postId); //回傳檢舉結果
			
			request.setAttribute("postId", postId); //送postId出去
			request.setAttribute("reportResult", reportResult); //顯示檢舉結果
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/showPostServlet");
			rd.forward(request, response);
			return;
			
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
