package T4_01.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cs")
public class cookieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("username", "SSD");
		Cookie cookie2 = new Cookie("password", "123456");
		Cookie cookie3 = new Cookie(URLEncoder.encode("姓名", "UTF-8"),URLEncoder.encode("施育群", "UTF-8"));
		cookie.setPath("/campingmapping/get");
		cookie2.setPath("/campingmapping");
		cookie3.setPath("/campingmapping/get");
		cookie.setMaxAge(60 * 60);
		cookie2.setMaxAge(60 * 60);
		cookie3.setMaxAge(60 * 60);
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
	}

}
