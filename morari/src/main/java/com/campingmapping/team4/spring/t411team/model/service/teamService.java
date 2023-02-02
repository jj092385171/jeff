package com.campingmapping.team4.spring.t411team.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t411team.model.Dao.repository.InitiatingRepository;
import com.campingmapping.team4.spring.t411team.model.entity.Initiating;

@Service
@Transactional
public class teamService {
	
	@Autowired
	private InitiatingRepository iRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	public Initiating insert(Initiating i ,UUID uid) {
		Date postday = new Date();
		i.setPostdate(postday);
		i.setUserprofiles(uRepo.findById(uid).get());
		return iRepo.save(i);
	}
	
	public Initiating update(Initiating i) {
		return iRepo.save(i);
	}
	
	public void delete(Integer id) {
		iRepo.deleteById(id);
	}
	
	public Initiating findById(Integer id) {
		Optional<Initiating> op = iRepo.findById(id);
		Initiating i = null;
		
		if(op.isPresent()) {
			i = op.get();
		}
		
		return i;
	}
	
	public List<Initiating> findAll(){
		return iRepo.findAll();
	}
	
	public List<Initiating> selectDynamic(String uid, Date startdate, Date enddate, String camparea){
		List<Initiating> result = new ArrayList<Initiating>();
		List<Initiating> dateList = new ArrayList<Initiating>();
		List<Initiating> campareaList = new ArrayList<Initiating>();
		boolean judge = true;
		
		if (startdate != null && enddate != null) {
			dateList = iRepo.findByStartdateGreaterThanEqualAndEnddateLessThanEqual(startdate, enddate);
			if(dateList.size() == 0) {
				judge = false;
			}
		}else if(startdate != null && enddate == null) {
			dateList = iRepo.findByStartdateGreaterThanEqual(startdate);
			if(dateList.size() == 0) {
				judge = false;
			}
		}else if (startdate == null && enddate != null) {
			dateList = iRepo.findByEnddateLessThanEqual(enddate);
			if(dateList.size() == 0) {
				judge = false;
			}
		}
		
		if(dateList.size() != 0 && !camparea.equals("0")) {
			campareaList = iRepo.findByCamparea(camparea);
			result.addAll(dateList);
			result.retainAll(campareaList);
		}else if (dateList.size() != 0 && camparea.equals("0")) {
			result.addAll(dateList);
		}else if(dateList.size() == 0 && !camparea.equals("0") && judge != false){
			campareaList = iRepo.findByCamparea(camparea);
			result.addAll(campareaList);
		}
		
		if(!uid.equals("0") && result.size() != 0) {
			Initiating i = new Initiating();
			i.setUserprofiles(uRepo.findById(UUID.fromString(uid)).get());
			List<Initiating> uList = iRepo.findByUserprofiles(i.getUserprofiles());
			result.retainAll(uList);
		}else if(!uid.equals("0") && result.size() == 0 && judge != false) {
			Initiating i = new Initiating();
			i.setUserprofiles(uRepo.findById(UUID.fromString(uid)).get());
			List<Initiating> uList = iRepo.findByUserprofiles(i.getUserprofiles());
			result.addAll(uList);
		}
		
		return result;
	}
	
}
