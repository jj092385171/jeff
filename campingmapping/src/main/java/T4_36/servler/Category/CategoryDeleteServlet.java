package T4_36.servler.Category;

import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/CategoryDeleteServlet.do")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(CategoryDeleteServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    	log.info("刪除書籍功能之Controller: 開始");
    	HttpSession session = req.getSession();
        String id = req.getParameter("id");
        String title = req.getParameter("title");

        CategoryService categoryService = new CategoryServiceImpl();
        try {
        	categoryService.delete(Integer.getInteger(id));
			session.setAttribute("BookDeleteMsg", "產品(" + title + ")刪除成功");
			log.info("刪除產品功能之Controller，產品(" + title + ")刪除成功");
		} catch(Exception ex) {
			session.setAttribute("BookDeleteMsg", "產品(" + title + ")刪除失敗");
			log.info("刪除產品功能之Controller，產品(" + title + ")刪除失敗，ex=" + ex);
		}
        return;
    }
}
