package T4_36.servler.Category;

import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig()
@WebServlet("/CategoryDeleteServlet.do")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("123");
		String ProductId = req.getParameter("ProductId");
		System.out.println(ProductId);

		CategoryService categoryService = new CategoryServiceImpl();
//		categoryService.delete(Integer.getInteger(id));
		categoryService.delete(Integer.getInteger(ProductId));
		req.getRequestDispatcher("/T4_36/html5up-editorial/Pd_ok.jsp");
	}
}
