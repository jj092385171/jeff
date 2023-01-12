package tw.spring.action;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.spring.model.Room;

public class DemoRoomAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		Room room1 = context.getBean("room1", Room.class);
		System.out.println(room1.getId() + " " + room1.getName() + " " + room1.getSize());
		
		Date current = new Date();
		
		Room room2 = context.getBean("room2", Room.class);
		System.out.println(room2.getId() + " " + room2.getName() + " " + room2.getSize()
		 + " " + room2.getDate().format(current));
		
		Room room3 = context.getBean("room3", Room.class);
		System.out.println(room3.getId() + " " + room3.getName() + " " + room3.getSize()
		 + " " + room3.getDate().format(current));
		
		Room room4 = context.getBean("room1", Room.class);
		Room room5 = context.getBean("room1", Room.class);
		
		System.out.println(room4.hashCode());
		System.out.println(room5.hashCode());
		
		context.close();
	}

}
