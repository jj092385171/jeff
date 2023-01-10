package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_09Job.model.service.JobServiceImpl;


@MultipartConfig()
@WebServlet("/JobServletDelete")
public class JobServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rackID = request.getParameter("de");
		int parseID = Integer.parseInt(rackID);
		JobServiceImpl jsdi = new JobServiceImpl();
		jsdi.deleteJob(parseID);

//		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/deleteSucces.jsp");

//		rd.forward(request, response);
		return;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

}
