package tw.spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional
public class ProfilesDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Profiles insert(Profiles pBean) {
		
		Session session = factory.openSession();
		
		if(pBean != null) {
			session.save(pBean);
		}
		
		session.close();
		return pBean;
	}
	
	public Profiles update(Profiles pBean) {
		
		Session session = factory.openSession();
		
		if(pBean != null) {
			session.update(pBean);
			session.flush();
		}
		
		session.close();
		return pBean;
	}
	
	public Profiles findById(int id) {
		
		Session session = factory.openSession();
		Profiles resultBean = session.get(Profiles.class, id);
		
		session.close();
		return resultBean;
	}
	
	public boolean delete(Profiles pBean) {
		
		Session session = factory.openSession();
		
		if(pBean != null) {
			session.delete(pBean);
			session.flush();
			session.close();
			return true;
		}
		
		session.close();
		return false;
	}
	
}
