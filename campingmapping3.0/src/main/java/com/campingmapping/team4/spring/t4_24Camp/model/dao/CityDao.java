package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;


@Repository
@Transactional
public class CityDao {

	@Autowired
	private SessionFactory factory;
	

	//搜尋全部城市
	public List<City> showAll() {
		Session session = factory.openSession();
		Query<City> query = session.createQuery("from City", City.class);
		List<City> resultList = query.getResultList();
		
		return resultList;
	}
	
	//透過cityID搜尋camps
	public Set<Camp> findCampsByCityID(int cityID) {
		Session session = factory.openSession();
		City city = session.get(City.class, cityID);
		
		if(city != null) {
			Set<Camp> camps = city.getCamps();
			return camps;
		}
		
		return null;
	}

}
