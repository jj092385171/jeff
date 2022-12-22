package tw.leonchen.action;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tw.leonchen.config.SpringJavaConfig;
import tw.leonchen.model.Person;

public class DemoPersonAction {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfig.class);

		Person person = context.getBean("person", Person.class);
		person.setAge(5);
		person.setName("mike");
		person.setGender("male");
		System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
		
		context.close();
	}

}
