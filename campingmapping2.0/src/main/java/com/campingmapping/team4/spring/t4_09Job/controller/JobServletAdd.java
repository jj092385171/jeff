package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.util.Map;

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
@WebServlet("/JobServletAdd")
public class JobServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		JobServiceImpl jobServiceImpl = new JobServiceImpl();
		JobBean jobBean = new JobBean();

		// 驗證會員id輸入格式
		try {
			Integer uID = Integer.parseInt(request.getParameter("id"));
			jobBean.setuID(uID);
		} catch (Exception e) {
			errorMessage.put("id", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);
		// 驗證刊登id輸入格式
		try {
			Integer rackID = Integer.parseInt(request.getParameter("rackID"));
			jobBean.setRackID(rackID);
//			System.out.println(jobBean.getuID());
			try {
				JobBean findBeanByRackID = jobServiceImpl.findBeanByRackID(rackID);
				if (findBeanByRackID.getRackID() == rackID) {
					errorMessage.put("rackID", "編號重複,新增失敗");
					request.setAttribute("ErrorMsg", errorMessage);
				}
			} catch (Exception e) {
			}
			
		} catch (Exception e) {
			errorMessage.put("rackID", "輸入格式錯誤");
			request.setAttribute("ErrorMsg", errorMessage);
		}

//		// 驗證刊登編號是否重複
//		Integer rackID = Integer.parseInt(request.getParameter("rackID"));
//		JobBean findBeanByRackID = jobServiceImpl.findBeanByRackID(rackID);
//		if (findBeanByRackID.getRackID() != 0) {
//			errorMessage.put("rackID", "編號重複,新增失敗");
//		}
//		request.setAttribute("ErrorMsg", errorMessage);
//		jobBean.setRackID(rackID);

		String job = request.getParameter("job");
		jobBean.setJob(job);
		System.out.println(jobBean);
		String salary = request.getParameter("salary");
		jobBean.setSalary(salary);

		// 驗證人數輸入格式
		try {
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			jobBean.setQuantity(quantity);

		} catch (Exception e) {
			errorMessage.put("quantity", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		String place = request.getParameter("place");
		jobBean.setPlace(place);
		String time = request.getParameter("time");
		jobBean.setTime(time);
		String date = request.getParameter("date");
		jobBean.setDate(date);
		String remark = request.getParameter("remark");
		jobBean.setRemark(remark);

		// 轉日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackUp(sd.parse(request.getParameter("rackUp")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackDown(sdf.parse(request.getParameter("rackDown")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 處理照片格式
		InputStream in = request.getPart("img").getInputStream();
		long size = request.getPart("img").getSize();
			try {
				Blob image = jobServiceImpl.fileToBlob(in, size);
				jobBean.setImg(image);
			} catch (Exception e) {
		}

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/insert.jsp");
			rd.forward(request, response);
			return;
		}
//		System.out.println(jobBean.getuID());
		jobServiceImpl.addJob(jobBean);

		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/addSuccess.jsp");
		rd.forward(request, response);
		return;
	}

}
