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

import T4_24.Dao.CampDao;
import T4_24.Dao.CampPlusCityPlusTagsDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityPlusTagsBean;
import T4_24.Models.TagPlusCampBean;


@WebServlet("/T4_24/IndexShowAllPageServlet")
public class IndexShowAllPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		CampPlusCityPlusTagsDao campPlusCityPlusTagsDao = new CampPlusCityPlusTagsDao();
		List<CampPlusCityPlusTagsBean> cctList = null;
		
		try {
			cctList = campPlusCityPlusTagsDao.showAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		session.setAttribute("cctList", cctList);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_24/CampIndex.jsp");
		rd.forward(request, response);
		

		return;
		
	}
}
