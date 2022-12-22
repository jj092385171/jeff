package t401;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.LimitsDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.MemberDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Limits;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

import util.HibernateUtils;

public class Testbean {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
//			List<Member> all = memberDaoImpl.getAll();
//			ListIterator<Member> listIterator = all.listIterator();
			Member byId = memberDaoImpl.getById(1);
//			System.out.println(byId.getAccount());
//			listIterator.forEachRemaining(m->System.out.println(m.toString()));
			System.out.println("----------------------------------");
	System.out.println(byId.getEmail());
			System.out.println(byId.getLimits().getAccount());
			System.out.println(byId.getLicense().getPassword());
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
		}
		
		
	}
	
}
