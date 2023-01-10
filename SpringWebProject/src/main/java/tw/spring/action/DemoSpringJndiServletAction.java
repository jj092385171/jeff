package tw.spring.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.spring.model.House;
import tw.spring.model.HouseService;

@WebServlet("/DemoSpringJndiServletAction.do")
public class DemoSpringJndiServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WebApplicationContext context;
	
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HouseService houseService = context.getBean("houseService", HouseService.class);
		House resultBean;
		try {
			resultBean = houseService.selectById(1001);
			if (resultBean!=null) {
				out.write(resultBean.getHouseid() + " " + resultBean.getHousename() + "<br/>");
			} else {
				out.write("no result");
			}
			
			out.write("<hr/>");
			
			List<House> lists = houseService.selectAll();
			for(House hBean : lists) {
				out.write(hBean.getHouseid() + " " + hBean.getHousename() + "<br/>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.close();
	}
}
