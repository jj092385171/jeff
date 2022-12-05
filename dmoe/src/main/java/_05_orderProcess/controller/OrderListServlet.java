package _05_orderProcess.controller;

import java.io.IOException;
import java.util.List;

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
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.service.impl.OrderServiceImpl;

@WebServlet("/_05_orderProcess/orderList.do")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(OrderListServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("讀取某位會員所有訂單之Controller: 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(false);
		if (session == null) {      // 使用逾時
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
			return;
		}
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		OrderService os = new OrderServiceImpl();
		List<OrderBean> memberOrders = os.findByMemberId(mb.getMemberId());
		request.setAttribute("memberOrders", memberOrders);
		log.info("讀取某位會員所有訂單之Controller: memberOrders=" + memberOrders);
		RequestDispatcher rd = request.getRequestDispatcher("/_05_orderProcess/OrderList.jsp");
		rd.forward(request, response);
		return;
	}
}
