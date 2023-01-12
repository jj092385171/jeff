package tw.spring.action;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.spring.model.House;
import tw.spring.model.HouseService;

public class DemoHouseJdbcAction {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
//		以id向Spring要求一個Bean
		HouseService houseService = context.getBean("houseService", HouseService.class);
		House resultBean = houseService.selectById(1000);
		
		if(resultBean != null) {
			System.out.println(resultBean.getHouseid() + " " + resultBean.getHousename());
		} else {
			System.out.println("no result");
		}
		
		context.close();
	}

}
