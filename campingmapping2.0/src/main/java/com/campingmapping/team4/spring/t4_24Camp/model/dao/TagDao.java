package T4_24.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import T4_24.model.Tag;


public class TagDao {
	
	private Session session;

	public TagDao(Session session) {
		this.session = session;
	}
		
	//搜尋全部標籤
	public List<Tag> showAll(){
		System.out.println("555");
		Query<Tag> query = session.createQuery("from Tag", Tag.class);
		System.out.println("666");
		List<Tag> resultList = query.getResultList();
		
		return resultList;
	}	
	

}
