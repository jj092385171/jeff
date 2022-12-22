package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobServiceImpl;

@MultipartConfig()
@WebServlet("/JobServletFindBeanByRackID")
public class JobServletFindBeanByRackID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		String rackID = request.getParameter("up");
		int rint = Integer.parseInt(request.getParameter("up"));
		JobServiceImpl jsi = new JobServiceImpl();
		JobBean JobBean = jsi.findBeanByRackID(rint);
//		System.out.println(JobBean);
		request.setAttribute("JobBean", JobBean);
		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/update.jsp");
		rd.forward(request, response);
		return;
	}

}
