package T4_01.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import T4_01.beans.Limits;

@WebFilter(urlPatterns = {"/*"},

		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_Allproduct.jsp
		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_delet.jsp
		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_index.jsp
		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_insert.jsp
		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_ok.jsp
		/// campingmapping/src/main/webapp/T4_36/html5up-editorial/Pd_update.jsp

		initParams = {
				@WebInitParam(name = "mustLogin1", value = "/T4_36/html5up-editorial/Pd_Allproduct.jsp"),
				@WebInitParam(name = "mustLogin2", value = "/T4_36/html5up-editorial/Pd_delet.jsp"),
				@WebInitParam(name = "mustLogin3", value = "/T4_36/html5up-editorial/Pd_index.jsp"),
				@WebInitParam(name = "mustLogin4", value = "/T4_36/html5up-editorial/Pd_insert.jsp"),
				@WebInitParam(name = "mustLogin5", value = "/T4_36/html5up-editorial/Pd_ok.jsp"),
				@WebInitParam(name = "mustLogin6", value = "/T4_36/html5up-editorial/Pd_update.jsp"),})

public class ShopFilter implements Filter {
	private static Logger log = LoggerFactory
			.getLogger(LoginCheckingFilter.class);

	List<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String path = e.nextElement();
			url.add(fConfig.getInitParameter(path));
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("f");
		boolean isRequestedSessionIdValid = false;
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			servletPath = req.getServletPath();
			contextPath = req.getContextPath();
			requestURI = req.getRequestURI();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();

			if (mustLogin()) {
				if (checkLogin(req)) {
					log.info("需要登入，但已經登入");

					chain.doFilter(request, response);
				} else {
					log.info("需要登入，尚未登入，所以送回登入畫面");
					HttpSession session = req.getSession();

					if (!isRequestedSessionIdValid) {
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					} else {
						// 記住原本的"requestURI"，稍後如果登入成功，系統可以自動轉入
						// 原本要執行的程式。
						session.setAttribute("requestURI", requestURI);
					}
					resp.sendRedirect(resp.encodeRedirectURL(
							contextPath + "/T4_01/login/login.html"));
					return;
				}
			} else { //
				log.info("不需要登入，直接去執行他要執行的程式");

				chain.doFilter(request, response);
			}
		} else {
			throw new ServletException("Request/Response 型態錯誤(極不可能發生)");
		}
	}
	// 判斷Session物件內是否含有識別字串為LoginOK的屬性物件，如果有，表示已經登入，否則尚未登入
	private boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();

		Limits loginToken = (Limits) session.getAttribute("limits");
		if (loginToken == null) {
			return false;
		} else if (loginToken.getSell().toUpperCase().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	// 如果請求的ServletPath的前導字是以某個必須登入才能使用之資源的路徑，那就必須登入。
	private boolean mustLogin() {
		boolean login = false;
		for (String sURL : url) {
			if (sURL.endsWith("*")) {
				sURL = sURL.substring(0, sURL.length() - 1); // 除去掉最後一個字元的剩餘字串
				if (servletPath.startsWith(sURL)) {
					login = true;
					break;
				}
			} else {
				if (servletPath.equals(sURL)) {
					login = true;
					break;
				}
			}
		}
		return login;
	}
	@Override
	public void destroy() {
	}

}
