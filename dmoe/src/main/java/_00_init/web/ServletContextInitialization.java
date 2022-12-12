package _00_init.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.GlobalService;

@WebListener
public class ServletContextInitialization implements ServletContextListener {

	private static Logger log = LoggerFactory.getLogger(ServletContextInitialization.class);
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("SYSTEM", new GlobalService() );
    	log.info("已經將GlobalService 物件放入applicationScope中");
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
}
