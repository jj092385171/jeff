package _03_listBooks.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

@WebServlet("/_03_listBooks/DisplayPageProducts")
// 本控制器負責進行必要的前置作業，以便程式能讀取某一頁的商品資料
public class RetrievePageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(RetrievePageProducts.class);
	
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先取出session物件
		log.info("讀取一頁商品資料之Controller: 開始");
		HttpSession session = request.getSession(false);

		// 如果session物件不存在
		if (session == null) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL(
					request.getContextPath() + "/_02_login/login.jsp"));
			return;
		}
		// 若登入成功，Session範圍內會有LoginOK對應的MemberBean物件
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		// 取出使用者的memberId，後面的Cookie會用到 
		String memberId = mb.getMemberId();
		// BookService介面負責讀取資料庫內Book表格內某一頁的書籍資料，並提供新增、修改、刪除
		// 書籍資料的功能。
		
		// 讀取瀏覽送來的 pageNo，如果直接點選主功能表的『購物』超連結，網頁不會送pageNo給後端伺服器
		String pageNoStr = request.getParameter("pageNo");
		// 如果讀不到：
		if (pageNoStr == null) {  
			pageNo = 1;
			// 先到瀏覽器送來的Cookies內尋找
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				// 逐筆檢視Cookie內的資料
				for (Cookie c : cookies) {
					if (c.getName().equals(memberId + "pageNo")) {
						try {
							pageNo = Integer.parseInt(c.getValue().trim());
						} catch (NumberFormatException e) {
							;
						}
						break;
					}
				}
			}
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
		log.info("讀取一頁商品資料之Controller: pageNo=" + pageNo + ", memberId=" + memberId);
		BookService bookService = new BookServiceImpl(); 
		
		request.setAttribute("baBean", bookService);
		// bookService.getPageBooks()方法開始讀取一頁的書籍資料
		// 讀取一頁的書籍資料，經由參數告訴service現在要讀哪一頁
		Map<Integer, BookBean> bookMap = bookService.getPageBooks(pageNo);
		session.setAttribute("pageNo", String.valueOf(pageNo));
		request.setAttribute("totalPages", bookService.getTotalPages());
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		session.setAttribute("products_DPP", bookMap);
		log.info("bookMap=" + bookMap);
		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
		// -----------------------
		Cookie pnCookie = new Cookie(memberId + "pageNo", String.valueOf(pageNo));
	    // 設定Cookie的存活期為30天
		pnCookie.setMaxAge(30 * 24 * 60 * 60);
	    // 設定Cookie的路徑為 Context Path		
		pnCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
		response.addCookie(pnCookie);
		// -----------------------
		// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
		// 『前一頁』、『下一頁』、『最末頁』等資料
		RequestDispatcher rd = request.getRequestDispatcher("/_03_listBooks/listBooks.jsp");
		rd.forward(request, response);
		return;
	}
}