package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobServiceImpl;


 
@WebServlet("/JobServletShowAll")
public class JobServletShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		JobServiceImpl jobServiceImpl = new JobServiceImpl();		
		List<JobBean> showAllJob = jobServiceImpl.showAllJob();
		request.setAttribute("showAllJob", showAllJob);		

		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/showAll.jsp");

		rd.forward(request, response);
		return;
	}

}
