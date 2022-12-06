package T4_36.servler.Category;

import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update/category.do")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Category category = (Category) req.getAttribute("category");

        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.update(category);
    }
}
