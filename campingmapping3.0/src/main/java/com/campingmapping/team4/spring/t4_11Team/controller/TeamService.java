package com.campingmapping.team4.spring.t4_11Team.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.campingmapping.team4.spring.t4_11Team.Dao.InitiatingDao;
import com.campingmapping.team4.spring.t4_11Team.model.Initiating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeamService implements TService{
	
	@Autowired
	private InitiatingDao iDao;
	
	@Override
	public Initiating setInitiating(Map<String,String[]> initiating) {
		return iDao.setInitiating(initiating);
	}
	
	@Override
	public Initiating insertInitiating(Initiating initiating) {
		return iDao.insertInitiating(initiating);
	}
	
	@Override
	public boolean deleteInitiating(int initiatingnum) {
		return iDao.deleteInitiating(initiatingnum);
	}
	
	@Override
	public Initiating updateInitiating(Initiating initiating) {
		return iDao.updateInitiating(initiating);
	}
	
	@Override
	public List<Initiating> selectAllInitiating(){
		return iDao.selectAllInitiating();
	}
	
	@Override
	public List<Initiating> selectAllCamparea(){
		return iDao.selectAllCamparea();
	}
	
	@Override
	public List<Initiating> selectAllMember(){
		return iDao.selectAllMember();
	}

	@Override
	public String hqlCommand(String startdate, String enddate, String initiatingnum, String postmember,
			String camparea) {
		return iDao.hqlCommand(startdate, enddate, initiatingnum, postmember, camparea);
	}

	@Override
	public List<Initiating> selectInitiating(String sql) {
		return iDao.selectInitiating(sql);
	}

}
