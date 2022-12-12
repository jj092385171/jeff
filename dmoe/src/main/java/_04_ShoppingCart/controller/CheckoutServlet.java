package _04_ShoppingCart.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.model.ShoppingCart;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.service.impl.OrderServiceImpl;

@WebServlet("/_04_ShoppingCart/checkout.do")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderService orderService = new OrderServiceImpl();
	
	private static Logger log = LoggerFactory.getLogger(CheckoutServlet.class);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("訂單前期檢查之Controller: 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(false);

		if (session == null) {      // 使用逾時
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
			return;
		}
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (shoppingCart == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
			return;
		}
		
		try {
			orderService.preCheckStock(shoppingCart);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/OrderConfirm.jsp");
			rd.forward(request, response);
			log.info("訂單前期檢查之Controller, 先期核對商品之庫存量，核對結果：OK");
			return;
		}  catch(RuntimeException ex){
			String message = ex.getMessage();
			String shortMsg = "" ;   
			shortMsg =  message.substring(message.indexOf(":") + 1);
			log.warn("先期核對商品之庫存量，核對結果：NG: " + shortMsg  + "，請調正訂單內容" );
			session.setAttribute("OrderErrorMessage", "核對商品庫存量發生異常: " 
								+ shortMsg  + "，請調正訂單內容" );
			response.sendRedirect(response.encodeRedirectURL (contextPath 
								+ "/_04_ShoppingCart/ShowCartContent.jsp"));
			return;
		}
		
		
	}
}