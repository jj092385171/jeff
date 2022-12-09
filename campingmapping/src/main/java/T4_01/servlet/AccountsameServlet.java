package T4_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import T4_01.service.impl.JoinServiceImpl;

@WebServlet("/accountsame")
public class AccountsameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			PrintWriter printWriter = resp.getWriter();
			String account = req.getParameter("account");
//			System.out.println("req "+account);
			Map<String, Object> accountsame = new JoinServiceImpl().accountsame(account);
			String json = new Gson().toJson(accountsame);
			printWriter.println(json);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
