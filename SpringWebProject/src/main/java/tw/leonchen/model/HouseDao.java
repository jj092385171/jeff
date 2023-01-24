package tw.leonchen.model;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public House selectById(int houseid) throws SQLException  {
		Session session = sessionFactory.getCurrentSession();
		House resultBean = session.get(House.class, houseid);
		return resultBean;
	}

	public List<House> selectAll(){
		Session session = sessionFactory.getCurrentSession();
		Query<House> query = session.createQuery("from House", House.class);
		return query.list();
	}
	
}
