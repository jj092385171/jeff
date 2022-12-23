package _05_orderProcess.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.service.impl.OrderServiceImpl;

// 依照會員編號與訂單編號來讀取某筆訂單的所有資料，這些資料將封裝為一個OrderBean物件

@WebServlet("/_05_orderProcess/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger log = LoggerFactory.getLogger(OrderDetailServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("讀取某筆訂單的所有資料之Controller: 開始");
		String orderNo = request.getParameter("orderNo");
		int no = Integer.parseInt(orderNo.trim());

		OrderService orderService = new OrderServiceImpl();
		OrderBean orderBean = orderService.findById(no);
		request.setAttribute("OrderBean", orderBean);   // 將OrderBean物件暫存到請求物件內
		log.info("OrderBean=" + orderBean);
		RequestDispatcher rd = request.getRequestDispatcher("/_05_orderProcess/ShowOrderDetail.jsp");
		rd.forward(request, response);
		return;
	}
}