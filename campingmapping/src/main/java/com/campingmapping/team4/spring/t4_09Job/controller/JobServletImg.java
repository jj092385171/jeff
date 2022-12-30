package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobServiceImpl;


@MultipartConfig()
@WebServlet("/JobServletImg")
public class JobServletImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OutputStream os = null;
		InputStream is = null;
		Blob blob = null;
		try {
			String rackID = request.getParameter("id");
			int parseID = Integer.parseInt(rackID);
			JobServiceImpl jsdi = new JobServiceImpl();
			JobBean jobBean = jsdi.findImgByRackID(parseID);
			blob = jobBean.getImg();
			is = blob.getBinaryStream();
			os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8000];
			while ((len = is.read(bytes)) != -1) {
			os.write(bytes, 0, len);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失敗");
		}finally {
			if (is != null) is.close();
            if (os != null) os.close();
		}
	}
}
