package com.campingmapping.team4.spring.t4_01Member.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.MemberDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.google.gson.GsonBuilder;

@WebServlet("/TestSer")
public class TestSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		List<Member> all = new MemberDaoImpl().getAll();
		PrintWriter writer = response.getWriter();
		String jsonString = new GsonBuilder().serializeNulls().create().toJson(all);
		writer.println(jsonString);

	}

}
