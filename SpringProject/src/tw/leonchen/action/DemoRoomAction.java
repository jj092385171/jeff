package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Room;

public class DemoRoomAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		Room room1 = context.getBean("room1", Room.class);
		System.out.println(room1.getId() + " " + room1.getName() + " " + room1.getSize());
		
		Room room2 = context.getBean("room2", Room.class);
		System.out.println(room2.getId() + " " + room2.getName() + " " + room2.getSize() + " " + room2.getSimpDateFormat() );
		
		context.close();

	}

}
