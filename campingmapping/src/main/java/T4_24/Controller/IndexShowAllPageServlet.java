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
import javax.servlet.http.HttpSession;

import T4_24.Dao.CampSiteCityTagsDao;
import T4_24.Models.CampSiteCityTagsBean;


@WebServlet("/T4_24/IndexShowAllPageServlet")
public class IndexShowAllPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		CampSiteCityTagsDao campPlusCityPlusTagsDao = new CampSiteCityTagsDao();
		List<CampSiteCityTagsBean> showAll = null;
		
		try {
			showAll = campPlusCityPlusTagsDao.showAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		session.setAttribute("showALL", showAll);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_24/CampIndex.jsp");
		rd.forward(request, response);
		

		return;
		
	}
}
