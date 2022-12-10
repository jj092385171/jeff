package T4_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import T4_01.beans.License;
import T4_01.service.LoginService;
import T4_01.service.impl.LoginServiceImpl;

@WebServlet("/login")
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(LonginServlet.class);
	Map<String, Object> userInfoMap = new HashMap<String, Object>();

	protected void processRequest(HttpServletRequest req,

			HttpServletResponse resp) {
		log.info("認證完成準備配對密碼");
		try {
			PrintWriter printWriter = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();

			// 1.拿資料
			String account = req.getParameter("account");
			String passwordInput = req.getParameter("password");
			String sha1Hex1 = DigestUtils.sha1Hex(passwordInput);
			String password = DigestUtils.sha1Hex(sha1Hex1);
			String rember = req.getParameter("rember");
			log.info(account + "  " + password + " " + rember);
			String ipAddress = req.getHeader("X-FORWARDED-FOR");
			// String remoteAddr = req.getRemoteAddr();
			if (ipAddress == null || "".equals(ipAddress)) {
				ipAddress = req.getRemoteAddr();
			}
			// 2.業務邏輯
			LoginService loginService = new LoginServiceImpl();
			License license = loginService.login(account, password);
			// 3.處理結果

			if (license != null) {
				// 成功
				// 寫入登入歷史
				log.info("登入成功");
				loginService.loginHistory(account, ipAddress);
				// 成功建構要回傳JSON物件和session
				session = loginService.loginSession(account, session);
				processCookies(req, resp, account, passwordInput, rember);

				userInfoMap.put("res", 1);
				JSONObject reUser = new JSONObject(userInfoMap);
				printWriter.println(reUser);
			} else {
				// 失敗
				log.info("登入失敗");

				userInfoMap.put("res", 0);
				JSONObject reUser = new JSONObject(userInfoMap);
				printWriter.println(reUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void processCookies(HttpServletRequest req,
			HttpServletResponse resp, String account, String passwordInput,
			String rember) {
		// **********Remember Me****************************
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		// rm存放瀏覽器送來之RememberMe的選項，如果使用者對RememberMe打勾，rm就不會是null
		if (rember != null) {
			cookieUser = new Cookie("account", account);
			cookieUser.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
			cookieUser.setPath(req.getContextPath());

			String Password = DigestUtils.sha1Hex(passwordInput);
			cookiePassword = new Cookie("password", Password);
			cookiePassword.setMaxAge(30 * 24 * 60 * 60);
			cookiePassword.setPath(req.getContextPath());

			cookieRememberMe = new Cookie("rember", "true");
			cookieRememberMe.setMaxAge(30 * 24 * 60 * 60);
			cookieRememberMe.setPath(req.getContextPath());
		} else { // 使用者沒有對 RememberMe 打勾
			cookieUser = new Cookie("account", account);
			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(req.getContextPath());

			String Password = DigestUtils.sha1Hex(passwordInput);
			cookiePassword = new Cookie("password", Password);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(req.getContextPath());

			cookieRememberMe = new Cookie("rember", "true");
			cookieRememberMe.setMaxAge(0);
			cookieRememberMe.setPath(req.getContextPath());
		}
		resp.addCookie(cookieUser);
		resp.addCookie(cookiePassword);
		resp.addCookie(cookieRememberMe);
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