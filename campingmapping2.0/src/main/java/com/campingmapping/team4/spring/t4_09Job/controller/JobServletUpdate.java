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
@WebServlet("/JobServletUpdate")
public class JobServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		JobServiceImpl jobServiceImpl = new JobServiceImpl();
		JobBean jobBean = new JobBean();

		String str = request.getParameter("rackID");
		Integer rackID = Integer.parseInt(str.trim());
		String job = request.getParameter("job");
		String salary = request.getParameter("salary");
		String place = request.getParameter("place");
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String remark = request.getParameter("remark");

		// 處理照片格式
		InputStream in = request.getPart("img").getInputStream();
		long size = request.getPart("img").getSize();
		try {
			Blob image = jobServiceImpl.fileToBlob(in, size);
			JobServiceImpl jsi = new JobServiceImpl();

			jobBean = jsi.findBeanByRackID(rackID);
			if (size != 0) {
				jobBean.setImg(image);
			}
		} catch (Exception e) {
		}

		// 驗證會員id輸入格式
		try {
			Integer uID = Integer.parseInt(request.getParameter("id"));
			jobBean.setuID(uID);
		} catch (Exception e) {
			errorMessage.put("id", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		// 驗證人數輸入格式
		try {
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			jobBean.setQuantity(quantity);
		} catch (Exception e) {
			errorMessage.put("quantity", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

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

		jobBean.setRackID(rackID);
		jobBean.setJob(job);
		jobBean.setSalary(salary);
		jobBean.setPlace(place);
		jobBean.setTime(time);
		jobBean.setDate(date);
		jobBean.setRemark(remark);

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/update.jsp");
			rd.forward(request, response);
			return;
		}
		jobServiceImpl.updateJob(jobBean);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/updateSucces.jsp");
		rd.forward(request, response);
		return;

	}

}
