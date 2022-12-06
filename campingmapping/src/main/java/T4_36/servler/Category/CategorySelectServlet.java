package T4_36.servler.Category;

import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select/category.do")
public class CategorySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");

        CategoryService categoryService = new CategoryServiceImpl();
        Category category = categoryService.select(Integer.getInteger(id));
    }
}
