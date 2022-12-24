package T4_36.servler.Category;

import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryQueryServlet.do")
public class CategoryQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		CategoryService cgS = new CategoryServiceImpl();
		
		Category category = cgS.select(Integer.parseInt(id));
		
		req.setAttribute("querybyproductno", category);
		
		RequestDispatcher rd = req.getRequestDispatcher("/SHOP_DETAIL/ProductQuery_Result.jsp");
		rd.forward(req, resp);
		return;
    }
}