package com.campingmapping.team4.spring.t4_36SMall.controller.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_36SMall.model.entity.Category;
import com.campingmapping.team4.spring.t4_36SMall.model.service.impl.CategoryServiceImpl;

@MultipartConfig()
@WebServlet("/CategorySelectByPdidServlet.do")
public class CategorySelectByPdidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		int parameter = Integer.parseInt(req.getParameter("pdid"));
		System.out.println(parameter);
		CategoryServiceImpl cgS = new CategoryServiceImpl();

		Category select;
		try {
			select = cgS.select(parameter);
			req.setAttribute("Category", select);
			System.out.println(select.toString());
			RequestDispatcher rd = req
					.getRequestDispatcher("http://localhost:8080/campingmapping2.0/t4_36shop/admin/Pd_update.jsp");
			rd.forward(req, resp);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
