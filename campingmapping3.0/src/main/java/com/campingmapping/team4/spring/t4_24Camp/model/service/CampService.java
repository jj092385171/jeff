package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;

@Service
@Transactional
public class CampService {
	
	@Autowired
	private CampDao campDao;
	

	//新增營地
	public Camp AddCamp(Camp camp) {
		return campDao.AddCamp(camp);
	}	
		
	//搜尋全部
	public List<Camp> showAll(){
		return campDao.showAll();
	}
	
	//透過campID查詢camp
	public Camp findCampByID(int campID) {
		return campDao.findCampByID(campID);
	}
	
	//更新營地
	public Camp updateByCampID(int campID , String campName, int cityID, String location, Blob campPictures, String description, Set<Tag> tags) {
		return campDao.updateByCampID(campID, campName, cityID, location, campPictures, description, tags);
	}
	
	//刪除營地
	public boolean deletdByCampID(int campID){
		return campDao.deletdByCampID(campID);
	}
	
	//刪除TagOfCamp
	public boolean deletdTagsByID(int campID){
		return campDao.deletdTagsByID(campID);
	}
	
	//刪除SitebyCampID
	public boolean deleteSitesbyCampID(int campID){
		return campDao.deleteSitesbyCampID(campID);
	}
	
}
