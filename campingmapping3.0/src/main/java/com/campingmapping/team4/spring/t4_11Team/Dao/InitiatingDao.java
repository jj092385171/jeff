package com.campingmapping.team4.spring.t4_11Team.Dao;

import java.util.List;
import java.util.Map;

import com.campingmapping.team4.spring.t4_11Team.model.Initiating;

public interface InitiatingDao {
	
	public String hqlCommand(String startdate, String enddate, String initiatingnum, String postmember, String camparea);
	
	public Initiating setInitiating(Map<String,String[]> initiating);
	
	public Initiating insertInitiating(Initiating initiating);
	
	public boolean deleteInitiating(int initiatingnum);
	
	public Initiating updateInitiating(Initiating initiating);
	
	public List<Initiating> selectInitiating(String sql);

	public List<Initiating> selectAllInitiating();
	
	public List<Initiating> selectAllCamparea();
	
	public List<Initiating> selectAllMember();
	
	public Initiating findById(int initiatingnum); 
}
