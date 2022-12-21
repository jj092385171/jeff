package com.campingmapping.team4.spring.t4_36Shop.controller.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;
import com.campingmapping.team4.spring.t4_36Shop.model.service.CategoryService;
import com.campingmapping.team4.spring.t4_36Shop.model.service.impl.CategoryServiceImpl;

@WebServlet("/SelectAllServlet.do")
public class CategorySelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	req.setCharacterEncoding("UTF-8");
		CategoryService cgS = new CategoryServiceImpl();
		
		List<Category> list = null;
		try {
			list = cgS.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("AllList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/Hibernate_web/Pd_Allproduct.jsp");
		rd.forward(req, resp);
	}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	doPost(req, resp);
    }
}
