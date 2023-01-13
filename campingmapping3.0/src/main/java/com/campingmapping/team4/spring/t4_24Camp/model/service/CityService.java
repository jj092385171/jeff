package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CityDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;

@Service
@Transactional
public class CityService {
	
	@Autowired
	private CityDao cityDao;

	
	//透過ID搜尋City
	public City findCityByID(int cityID) {
		return cityDao.findCityByID(cityID);
	}
	
	//搜尋全部城市
	public List<City> showAll() {
		return cityDao.showAll();
	}
	
	//透過cityID搜尋camps
	public Set<Camp> findCampsByCityID(int cityID) {
		return cityDao.findCampsByCityID(cityID);
	}
	
}
