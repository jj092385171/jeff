package _20_productMaintain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;
import _03_listBooks.service.CompanyService;
import _03_listBooks.service.impl.BookServiceImpl;
import _03_listBooks.service.impl.CompanyServiceImpl;

@WebServlet("/_20_productMaintain/BookPreUpdate.do")
public class BookPreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = LoggerFactory.getLogger(BookPreUpdateServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		log.info("更新書籍之前置作業之Controller, 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(false);
		
		if (session == null) {
		     response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
		     return;
		}
		int bookId = 0;
		String strBookId = request.getParameter("BOOKID");
		
		if (strBookId != null) {
			bookId = Integer.parseInt(strBookId);
		}
		
		BookService bookService = new BookServiceImpl();
		BookBean bean = bookService.findById(bookId);
		session.setAttribute("bean", bean);

		//bookService.setSelected(bean.getCategory());
		String categoryTag = bookService.getCategoryTag(bean.getCategory());
		log.info("更新書籍之前置作業之Controller, categoryTag=" + categoryTag); 
		session.setAttribute("SelectCategoryTag", categoryTag);
		CompanyService companyService = new CompanyServiceImpl();
		
		String companyTag = companyService.getSelectTag("companyID", bean.getCompanyId());
		log.info("更新書籍之前置作業之Controller, companyTag=" + companyTag);
		session.setAttribute("SelectCompanyTag", companyTag);

		RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookUpdate.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
