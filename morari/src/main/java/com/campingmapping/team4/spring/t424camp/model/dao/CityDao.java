package com.campingmapping.team4.spring.t424camp.model.dao;
// package com.campingmapping.team4.spring.t4_24Camp.model.dao;

// import java.util.List;
// import java.util.Set;

// import org.hibernate.Session;
// import org.hibernate.query.Query;

// import com.campingmapping.team4.spring.t4_24Camp.model.entity.Camp;
// import com.campingmapping.team4.spring.t4_24Camp.model.entity.City;

// public class CityDao {

// private Session session;

// public CityDao(Session session) {
// this.session = session;
// }

// // 搜尋全部城市
// public List<City> showAll() {
// Query<City> query = session.createQuery("from City", City.class);
// List<City> resultList = query.getResultList();

// return resultList;
// }

// // 透過cityID搜尋camps
// public Set<Camp> findCampsByCityID(int cityID) {
// City city = session.get(City.class, cityID);

// if (city != null) {
// Set<Camp> camps = city.getCamps();
// return camps;
// }

// return null;
// }

// }
