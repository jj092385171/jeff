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

import T4_24.Dao.CityDao;
import T4_24.Models.CityBean;


@WebServlet("/T4_24/QueryPageServlet")
public class QueryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//查詢頁面, 顯示所有city
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CityDao cityDao = new CityDao();
		try {
			List<CityBean> cityList = cityDao.showAll();
			request.setAttribute("cityList", cityList);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/QueryPageForm.jsp");
			rd.forward(request, response);
			return;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
