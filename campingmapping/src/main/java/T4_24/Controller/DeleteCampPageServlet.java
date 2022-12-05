package T4_24.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_24.Dao.CampDao;
import T4_24.Models.CampBean;


@WebServlet("/T4_24/DeleteCampPageServlet")
public class DeleteCampPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CampDao campDao = new CampDao();
		
		try {
			List<CampBean> campList = campDao.showID();
			request.setAttribute("campList", campList);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/DeleteCampByIDForm.jsp");
			System.out.println("666");
			rd.forward(request, response);
			return;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
