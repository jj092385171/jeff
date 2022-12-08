package T4_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import T4_01.beans.License;
import T4_01.service.LoginService;
import T4_01.service.impl.LoginServiceImpl;

@WebServlet("/login")
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		System.out.println("認證完成準備配對密碼");

		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			// 1.拿資料
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			System.out.println(account + "  " + password);
			// 2.業務邏輯
			LoginService loginService = new LoginServiceImpl();
			License license = loginService.login(account, password);
			// 3.處理結果
			
			PrintWriter printWriter = resp.getWriter();
			Map<String, Object> userInfoMap = new HashMap<String, Object>();
			if (license != null) {
				// 成功建構要回傳JSON物件和session
				HttpSession session = req.getSession();
				session = loginService.loginSession(account, session);
				session.setAttribute("License", license);
				userInfoMap.put("res", 1);
				JSONObject reUser = new JSONObject(userInfoMap);
				printWriter.println(reUser);

			} else {
				// 失敗
				userInfoMap.put("res", 0);
				JSONObject  reUser= new JSONObject(userInfoMap);
				printWriter.println(reUser);

			}
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