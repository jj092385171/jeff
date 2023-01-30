package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/InsertSiteGetCampIDServlet")
public class InsertSiteByCampIDPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	
		
		String campID = request.getParameter("campID");
		
		request.setAttribute("campID", campID);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/t4_24camp/admin/InsertSiteByIDForm.jsp");
		rd.forward(request, response);
		return;
		
	}

}
