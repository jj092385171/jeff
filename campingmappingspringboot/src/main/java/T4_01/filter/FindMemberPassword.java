package T4_01.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import T4_01.service.impl.ToolServiceImpl;


@WebFilter("/T4_01/login/login.html")
public class FindMemberPassword implements Filter {
	String requestURI;
	
	private static Logger log = LoggerFactory.getLogger(FindMemberPassword.class);
	
	public FindMemberPassword() {

	}	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 容器會在遠方客戶端提出請求、要求容器執行_02_login/login.jsp前，先執行本程式
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			// **********Remember Me****************
			String cookieName = "";
			String account = "";
			String password = "";
			String rember = "";
			// 取出瀏覽器送來的Cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {   						// 如果含有Cookie
				for (int i = 0; i < cookies.length; i++) {	// 檢視每個Cookie
					cookieName = cookies[i].getName();
					if (cookieName.equals("account")) {
						//找到account這個Cookie
						account = cookies[i].getValue();
					} else if (cookieName.equals("password")) {
						//找到password這個Cookie						
						String tmp  = cookies[i].getValue();
						// 將密碼解密
						if (tmp!= null){
							password = 	new ToolServiceImpl().remberloginsha1Hex(ToolServiceImpl.KEY,tmp);
						}
					} 
					else if (cookieName.equals("rember")) {
						//找到rember這個Cookie("rember": rember)
						rember = cookies[i].getValue();
					}
				}
			} else {
				// 找不到Cookie，沒有關係，讓使用者輸入資料即可。
			}
			log.info("account=" + account + ", password=" + password);
			// 將這三項資料存入request物件內，接下來執行的login.jsp就能取得這三份資料
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("rember", rember);    
			hashMap.put("account", account);  
			hashMap.put("password", password);
			JSONObject jsonObject = new JSONObject(hashMap);
//			PrintWriter writer = response.getWriter();
//			writer.println(jsonObject);
			HttpSession session = req.getSession();
			session.setAttribute("membercookie", jsonObject);
			
			request.setAttribute("rember", rember);
			request.setAttribute("account", account);
			request.setAttribute("password", password);
		}
		chain.doFilter(request, response);   // 請容器找出下一棒程式: login.jsp，然後執行它
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void destroy() {
	}
	
}
