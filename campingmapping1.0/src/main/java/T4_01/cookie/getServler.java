package T4_01.cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Cookie[] cookies = req.getCookies();
    	
    	if (cookies!=null) {
			for (Cookie cookie : cookies) {
				System.out.println(URLDecoder.decode(cookie.getName(), "UTF-8") + ":" + URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
			
		}
    	
    }
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	doGet(req, resp);
}
}
