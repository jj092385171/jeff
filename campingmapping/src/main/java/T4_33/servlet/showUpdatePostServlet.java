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
			PostDao dao = new PostDao(DbUtils.getConnection());			
			PostBean bean = dao.showPost(postId);
			
			request.setAttribute("title", bean.getTitle()); //傳送填寫的title
			request.setAttribute("content", bean.getContent()); //傳送填寫的content
			request.setAttribute("picture", bean.getPicture()); //傳送上傳的picture
			request.setAttribute("people", bean.getPeople()); //傳送選定的people
			request.setAttribute("price", bean.getPrice()); //傳送填寫的price
			request.setAttribute("county", bean.getCounty()); //傳送選定的county
			String stringStartDate = date.format(bean.getStartDate());
			request.setAttribute("startDate", stringStartDate); //傳送選定的startDate
			String stringEndDate = date.format(bean.getEndDate());
			request.setAttribute("endDate", stringEndDate); //傳送選定的endDate
			request.setAttribute("score", bean.getScore()); //傳送選定的score
			
			
			request.setAttribute("postId", postId); //送postId到updatePost
			
			RequestDispatcher rd = request.getRequestDispatcher("/T4_33/updatePost.jsp");
			rd.forward(request, response);
			return;
			
		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}
	}
}
