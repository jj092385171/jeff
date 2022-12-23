package t401;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.LoginHistoryDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.MemberDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.entity.LoginHistory;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

import util.HibernateUtils;

public class Testbean {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
//			LoginHistoryDaoImpl loginHistoryDaoImpl = new LoginHistoryDaoImpl();
//			List<LoginHistory> allliList = loginHistoryDaoImpl.getAll();
//			ListIterator<LoginHistory> listIterator = allliList.listIterator();
//			
//			listIterator.forEachRemaining(l ->System.out.println(l.toString()));
//			System.out.println("----------------------------------");
			MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
//			List<Member> all = memberDaoImpl.getAll();
//			ListIterator<Member> listIterator = all.listIterator();
			Member byId = memberDaoImpl.getById(23);
			String string = byId.getLimits().toString();
			System.out.println(string);
//			System.out.println(byId.getAccount());
//			listIterator.forEachRemaining(m->System.out.println(m.toString()));
//	System.out.println(byId.getEmail());
//			System.out.println(byId.getLimits().getAccount());
//			System.out.println(byId.getLicense().getPassword());
			Set<LoginHistory> loginHistories = byId.getLoginHistories();
//			System.out.println(loginHistories);
			loginHistories.forEach(s->System.out.println(s.toString()));
			
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
		}
		
		
	}
	
}
