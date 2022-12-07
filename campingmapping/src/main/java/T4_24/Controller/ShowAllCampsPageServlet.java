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
import T4_24.Dao.CampPlusCityDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityBean;


@WebServlet("/T4_24/ShowAllCampsPageServlet")
public class ShowAllCampsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CampPlusCityDao campPlusCityDao = new CampPlusCityDao();
		List<CampPlusCityBean> cpcList = null;
		try {
			cpcList = campPlusCityDao.showAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("cpcList", cpcList);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_24/Update_DeleteCampByIDForm.jsp");
		rd.forward(request, response);
		return;
		
	}
}
