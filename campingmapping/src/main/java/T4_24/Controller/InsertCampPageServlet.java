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
import T4_24.Dao.TagDao;
import T4_24.Models.CityBean;
import T4_24.Models.TagBean;


@WebServlet("/T4_24/InsertCampPageServlet")
public class InsertCampPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//顯示所有tag
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TagDao tagDao = new TagDao();
		CityDao cityDao = new CityDao();

		try {
			List<TagBean> tagList = tagDao.showAll();
			request.setAttribute("tagList", tagList);
			List<CityBean> cityList = cityDao.showAll();
			request.setAttribute("cityList", cityList);
			RequestDispatcher rd = request.getRequestDispatcher("/T4_24/InsertCampForm.jsp");
			rd.forward(request, response);
			return;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
