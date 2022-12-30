package com.campingmapping.team4.spring.t4_36Shop.controller.servlet;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_36Shop.model.service.CategoryService;
import com.campingmapping.team4.spring.t4_36Shop.model.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@MultipartConfig()
@WebServlet("/CategoryDeleteServlet.do")
public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
		String ProductId = req.getParameter("ProductId");

		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.delete(Integer.parseInt(ProductId));

		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath + "http://localhost:8080/campingmapping2.0/t4_36shop/admin/Pd_ok.jsp");
		} catch (IOException | NumberFormatException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
