package T4_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.GsonBuilder;

import T4_01.beans.Member;
import T4_01.service.impl.MemberServiceImpl;

@WebServlet("/ShowMemberServlet")
public class ShowMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			// System.out.println("in");
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			PrintWriter writer = resp.getWriter();
			List<Member> showMember = new MemberServiceImpl().showMember();
			// showMember.forEach(a->System.out.println(a.toString()));
			// String jsonString =
			// JSONObject.toJSONString(showMember,SerializerFeature.WriteNullStringAsEmpty);
			String jsonString = new GsonBuilder().serializeNulls().create()
					.toJson(showMember);
			
//			 System.out.println(jsonString);
			writer.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

}
