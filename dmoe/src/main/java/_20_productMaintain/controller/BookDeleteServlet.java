package _20_productMaintain.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_listBooks.service.BookService;
import _03_listBooks.service.impl.BookServiceImpl;

// 依照書籍的書號來刪除一本書籍的紀錄。本控制器會呼叫 BookService介面的deleteBook()方法來完成。
@WebServlet("/_20_productMaintain/BookDelete.do")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(BookDeleteServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("刪除書籍功能之Controller: 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String bId = request.getParameter("bookId");
		String bNo = request.getParameter("bookNo");
		int bookId = Integer.parseInt(bId);
		BookService bookService = new BookServiceImpl();
		try {
			bookService.deleteById(bookId);
			session.setAttribute("BookDeleteMsg", "書籍(" + bNo + ")刪除成功");
			log.info("刪除書籍功能之Controller，書籍(" + bNo + ")刪除成功");
		} catch(Exception ex) {
			session.setAttribute("BookDeleteMsg", "書籍(" + bNo + ")刪除失敗");
			log.info("刪除書籍功能之Controller，書籍(" + bNo + ")刪除失敗，ex=" + ex);
		}
		response.sendRedirect(response.encodeRedirectURL(contextPath 
				         + "/_20_productMaintain/DisplayPageProducts"));
		return;
	}
}
