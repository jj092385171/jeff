package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	
	private static final SessionFactory factory = createSessionFactory();
		
	
	private static SessionFactory createSessionFactory(){
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure().build();
		System.out.println("11111111111111");
		SessionFactory factory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		System.out.println("222222222");
		
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		System.out.println("33333333333333333");
		return factory;
	}
	
	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
		}
}
