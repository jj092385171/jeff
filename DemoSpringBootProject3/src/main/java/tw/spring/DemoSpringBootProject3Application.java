package tw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class DemoSpringBootProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootProject3Application.class, args);
	}

}
