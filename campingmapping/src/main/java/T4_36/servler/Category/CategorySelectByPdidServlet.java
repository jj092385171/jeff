package T4_36.servler.Category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_36.entity.Category;
import T4_36.service.impl.CategoryServiceImpl;

@MultipartConfig()
@WebServlet("/CategorySelectByPdidServlet.do")
public class CategorySelectByPdidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		int parameter = Integer.parseInt(req.getParameter("pdid"));
		CategoryServiceImpl cgS = new CategoryServiceImpl();

		Category select = cgS.select(parameter);

		req.setAttribute("querybyproductno", select);
		System.out.println(select.toString());
		RequestDispatcher rd = req.getRequestDispatcher("/T4_36/html5up-editorial/Pd_update.jsp");
		rd.forward(req, resp);
		return;

	}

}
