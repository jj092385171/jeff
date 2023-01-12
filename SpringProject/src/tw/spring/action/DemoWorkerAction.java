package tw.spring.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.spring.model.WorkerService;

public class DemoWorkerAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		WorkerService wService = context.getBean("wService", WorkerService.class);
		wService.printDetails();
		
		context.close();
	}

}
