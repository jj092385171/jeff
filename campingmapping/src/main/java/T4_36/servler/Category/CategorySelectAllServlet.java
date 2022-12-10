package T4_36.servler.Category;

import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectAllServlet.do")
public class CategorySelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	req.setCharacterEncoding("UTF-8");
		CategoryService cgS = new CategoryServiceImpl();
		
		List<Category> list = cgS.selectAll();
		System.out.println(list+"list");
		req.setAttribute("AllList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/T4_36/html5up-editorial/Pd_Allproduct.jsp");
		rd.forward(req, resp);
		return;
        
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	doPost(req, resp);
//    	req.setCharacterEncoding("UTF-8");
//		CategoryService cgS = new CategoryServiceImpl();
//		
//		List<Category> list = cgS.selectAll();
//		
//		req.setAttribute("AllList", list);
//		
//		RequestDispatcher rd = req.getRequestDispatcher("/T4_36/html5up-editorial/Pd_Allproduct.jsp");
//		rd.forward(req, resp);
//		return;
    }
}
