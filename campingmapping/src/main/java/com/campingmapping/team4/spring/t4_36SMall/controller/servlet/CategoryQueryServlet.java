package com.campingmapping.team4.spring.t4_36SMall.controller.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_36SMall.model.entity.Category;
import com.campingmapping.team4.spring.t4_36SMall.model.service.CategoryService;
import com.campingmapping.team4.spring.t4_36SMall.model.service.impl.CategoryServiceImpl;

@WebServlet("/CategoryQueryServlet.do")
public class CategoryQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		CategoryService cgS = new CategoryServiceImpl();

		Category category;
		try {
			category = cgS.select(Integer.parseInt(id));
			req.setAttribute("querybyproductno", category);
			RequestDispatcher rd = req.getRequestDispatcher("/SHOP_DETAIL/ProductQuery_Result.jsp");
			rd.forward(req, resp);
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
