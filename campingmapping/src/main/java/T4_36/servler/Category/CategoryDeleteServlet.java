package T4_36.servler.Category;

import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig()
@WebServlet("/CategoryDeleteServlet.do")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
		System.out.println("123");
		String ProductId = req.getParameter("ProductId");
		System.out.println(ProductId);

		CategoryService categoryService = new CategoryServiceImpl();
//		categoryService.delete(Integer.getInteger(id));
		categoryService.delete(Integer.parseInt(ProductId));

		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath + "/T4_36/html5up-editorial/Pd_ok.jsp");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
