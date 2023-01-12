package tw.spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository 
@Transactional
public class UsersDao {
	
	@Autowired
	private SessionFactory factory;
	
	public boolean checkLogin(Users user) {
		Session session = factory.openSession();
		
		String hql = "from Users where username=:user";
		Query<Users> query = session.createQuery(hql, Users.class);
		query.setParameter("user", user.getUsername());
		
		Users resultBean = query.uniqueResult();		
		session.close();
		
		if(resultBean!=null) {
			return true;
		}
		return false;
	}

}
