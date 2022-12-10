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

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import T4_01.service.impl.JoinServiceImpl;

@WebServlet("/join")
public class joinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(joinservlet.class);
	Map<String, Object> userInfoMap = new HashMap<String, Object>();

	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			PrintWriter printWriter = resp.getWriter();
			String account = req.getParameter("account");
			String passwordInput = req.getParameter("password");
			String sha1Hex1 = DigestUtils.sha1Hex(passwordInput);
			String password = DigestUtils.sha1Hex(sha1Hex1);
			String email = req.getParameter("email");
			String birthday = req.getParameter("birthday");
			JoinServiceImpl joinServiceImpl = new JoinServiceImpl();
			int joinNewMember = joinServiceImpl.joinNewMember(account, password,
					email, birthday);
			// System.out.println(account);
			// System.out.println(password);
			// System.out.println(email);
			// System.out.println(birthday);
			// System.out.println(ipAddress);
			// System.out.println(remoteAddr);

			if (joinNewMember == 1) {
				log.info("註冊成功");
				userInfoMap.put("res", 1);
				JSONObject reUser = new JSONObject(userInfoMap);
				printWriter.println(reUser);
			} else {
				log.info("註冊失敗");
				userInfoMap.put("res", 0);
				JSONObject reUser = new JSONObject(userInfoMap);
				printWriter.println(reUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
