package _20_productMaintain.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _01_register.model.MemberBean;
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;
import _03_listBooks.service.impl.BookServiceImpl;

@WebServlet("/_20_productMaintain/DisplayPageProducts")
public class DisplayMaintainProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(DisplayMaintainProducts.class);
	
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("維護書籍資料之顯示書籍功能之Controller: 開始");
		
		String contextPath = request.getContextPath();
		// 先取出session物件
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		String requestURI = request.getRequestURI();
		// System.out.println("requestURI=" + requestURI);
		// 如果session物件不存在
		if (session == null || session.isNew()) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL(
					contextPath  + "/_02_login/login.jsp"));
			return;
		}
		session.setAttribute("requestURI", requestURI);
		// 此時session物件存在，讀取session物件內的LoginOK
		// 以檢查使用者是否登入。
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(response.encodeRedirectURL(
					contextPath + "/_02_login/login.jsp"));
			return;
		}
		
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr == null) {
			pageNo = 1;
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
		
		BookService bookService = new BookServiceImpl();
		request.setAttribute("baBean", bookService);
		//
		Map<Integer, BookBean> bookMap = bookService.getPageBooks(pageNo);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPages", bookService.getTotalPages());
		request.setAttribute("products_DPP", bookMap);
		// 交由BookMaintainList.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
		// 『前一頁』、『下一頁』、『最末頁』等資料
		
		RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookMaintainList.jsp");
		rd.forward(request, response);
		log.info("維護書籍資料之顯示書籍功能之Controller: 成功");
		return;
	}
}