package tw.spring.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.spring.model.TreeBean;

public class DemoTreeBeanAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		TreeBean tree = context.getBean("tree", TreeBean.class);
		System.out.println(tree.getName() + " " + tree.getAge());
		
		context.close();
	}

}
