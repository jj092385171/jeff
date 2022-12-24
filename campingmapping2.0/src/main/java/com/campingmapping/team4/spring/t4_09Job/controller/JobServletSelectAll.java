package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig()
@WebServlet("/JobServletSelectAll")
public class JobServletSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String s1 = request.getParameter("job");
		Integer s2 = Integer.parseInt(request.getParameter("uID"));
		Integer s3 = Integer.parseInt(request.getParameter("rackID"));
		String s4 = request.getParameter("salary");
		Integer s5 = Integer.parseInt(request.getParameter("quantity"));
		String s6 = request.getParameter("place");
		String s7 = request.getParameter("time");
		String s8 = request.getParameter("date");
		String s9 = request.getParameter("remark");
		String s10 = request.getParameter("rackUp");
		String s11 = request.getParameter("rackDown");
		
		
//		JobServiceDAOImpl jsi = new JobServiceDAOImpl();
//		List<JobBean> jobBean = jsi.findJobSelectLike(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
//
//		request.setAttribute("jobBean", jobBean);
//		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/showSelect.jsp");
//		rd.forward(request, response);
//		return;
//		
//		
//		
		}
	}


