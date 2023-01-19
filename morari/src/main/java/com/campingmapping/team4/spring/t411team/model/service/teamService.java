package com.campingmapping.team4.spring.t411team.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	public Initiating insert(Initiating i ,Integer uid) {
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
		List<Initiating> dateList = iRepo.findByStartdateGreaterThanEqualAndEnddateLessThanEqual(startdate, enddate);
		List<Initiating> campareaList = iRepo.findByCamparea(camparea);
//		List<Initiating> uidList = iRepo.findByUid(uid);
		if(dateList!=null) {
			result.addAll(campareaList);
//			result.containsAll(uidList);
		}
		return result;
	}
	
}
