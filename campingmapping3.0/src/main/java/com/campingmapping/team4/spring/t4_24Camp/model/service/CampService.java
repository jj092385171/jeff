package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.CampDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;

@Service
@Transactional
public class CampService {
	
	@Autowired
	private CampDao campDao;
	

	//新增營地
	public int addCamp(String campName, Integer cityID, String location, String campPicturesPath, String description, int[] tagIDs) {
		return campDao.addCamp(campName, cityID, location, campPicturesPath, description, tagIDs);
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
	public Camp updateByCampID(int campID , String campName, Integer cityID, String location, String campPicturesPath, String description, int[] tagIDs) {
		return campDao.updateByCampID(campID, campName, cityID, location, campPicturesPath, description, tagIDs);
	}
	
	//刪除營地
	public boolean deletdByCampID(int campID){
		return campDao.deletdByCampID(campID);
	}
	
	
}