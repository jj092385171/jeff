package tw.leonchen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.leonchen.model.Person;

@Configuration
public class SpringJavaConfig {
	
	@Bean   //<bean id="person" class="tw.leonchen.model.Person"/>
	public Person person() {
		Person p1 = new Person();
		return p1;
	}

}
