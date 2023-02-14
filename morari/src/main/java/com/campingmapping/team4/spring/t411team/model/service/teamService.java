package com.campingmapping.team4.spring.t411team.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t411team.model.Dao.repository.InitiatingRepository;
import com.campingmapping.team4.spring.t411team.model.Dao.repository.MessageAreaRepository;
import com.campingmapping.team4.spring.t411team.model.Dao.repository.ThundsupRepository;
import com.campingmapping.team4.spring.t411team.model.entity.Initiating;
import com.campingmapping.team4.spring.t411team.model.entity.MessageArea;
import com.campingmapping.team4.spring.t411team.model.entity.Thundsup;

@Service
@Transactional
public class teamService {
	
	@Autowired
	private InitiatingRepository iRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private ThundsupRepository tRepo;
	
	@Autowired
	private MessageAreaRepository mRepo;
	
	//新增Initiating資料
	public Initiating insert(Initiating i ,UUID uid) {
		String information = "";
		
		information += "性別：" + i.getGender() + ";";
			if(i.getLodging() != null) {
				information += "預期住宿：";
				for(int x = 0 ; x < i.getLodging().length ; x++) {
					information += i.getLodging()[x] + ",";
				}
				information = information.substring(0, information.length()-1) + ";";
			}
			if(i.getEquipment() != null) {
				information += "目前裝備：";
				for(int x = 0 ; x < i.getEquipment().length ; x++) {
					information += i.getEquipment()[x] + ",";
				}
				information = information.substring(0, information.length()-1) + ";";
			}
		Date postday = new Date();
		i.setPostdate(postday);
		i.setTag(information);
		i.setUserprofiles(uRepo.findById(uid).get());
		i.setThumbsUp(0);
		i.setViewingCount(0);
		return iRepo.save(i);
	}
	
	//修改Initiating資料
	public Initiating update(Initiating i) {
		String information = "";
		
		information += "性別：" + i.getGender() + ";";
			if(i.getLodging() != null) {
				information += "預期住宿：";
				for(int x = 0 ; x < i.getLodging().length ; x++) {
					information += i.getLodging()[x] + ",";
				}
				information = information.substring(0, information.length()-1) + ";";
			}
			if(i.getEquipment() != null) {
				information += "目前裝備：";
				for(int x = 0 ; x < i.getEquipment().length ; x++) {
					information += i.getEquipment()[x] + ",";
				}
				information = information.substring(0, information.length()-1) + ";";
			}
			
		i.setTag(information);
		
		return iRepo.save(i);
	}
	
	//刪除Initiating資料
	public void delete(Integer id) {
		iRepo.deleteById(id);
	}
	
	//透過id查詢Initiating資料
	public Initiating findById(Integer id) {
		Optional<Initiating> op = iRepo.findById(id);
		Initiating i = null;
		
		if(op.isPresent()) {
			i = op.get();
		}
		
		return i;
	}
	
	//查詢Initiating全部資料
	public List<Initiating> findAll(){
		return iRepo.findAll();
	}
	
	//查詢Initiating分頁資料
	public Page<Initiating> findAllpage(Pageable pageable){
	    return iRepo.findAll(pageable);
	}
	
	//動態查詢
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
		}else if (startdate == null && enddate != null) {
			dateList = iRepo.findByEnddateLessThanEqual(enddate);
		}
		
		if(dateList.size() != 0 && !camparea.equals("0")) {
			campareaList = iRepo.findByCamparea(camparea);
			result.addAll(dateList);
			result.retainAll(campareaList);
		}else if (dateList.size()!= 0 && camparea.equals("0")) {
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
	
	//查詢按讚資料
	public List<Thundsup> selectThundsup(Integer num, UUID u) {
		
		ArrayList<Thundsup> resultList = new ArrayList<Thundsup>();
		Thundsup t = new Thundsup();
		Initiating i = new Initiating();
		t.setUserprofiles(uRepo.findById(u).get());
		i.setInitiatingnum(num);
		t.setInitiating(i);
		List<Thundsup> tList = tRepo.findByUserprofiles(t.getUserprofiles());
		List<Thundsup> iList = tRepo.findByInitiating(i);
		for (Thundsup thundsup1 : iList) {
			for (Thundsup thundsup2 : tList) {
				if (thundsup1.equals(thundsup2)) {
					resultList.add(thundsup2);
					return resultList;
				}
			}
		}
		return null;
	}
	
	
	//新增按讚資料
	public Thundsup insertThundsup(Integer num, UUID u) {
		
		Thundsup t = new Thundsup();
		Initiating i = new Initiating();
		
		t.setUserprofiles(uRepo.findById(u).get());
		i.setInitiatingnum(num);
		t.setUserprofiles(uRepo.findById(u).get());
		t.setInitiating(i);
		
		return tRepo.save(t);
	}
	
	//刪除按讚資料
	public void deleteThundsup(Integer tid) {
		tRepo.deleteById(tid);
	}
	
	//透過id查詢是否按讚
	public List<Thundsup> findThumbsUpByid(UUID uid){
		return tRepo.findByUserprofiles(uRepo.findById(uid).get());
	}
	
	//透過InitiatingID查詢留言
	public List<MessageArea> selectByMid(Integer iid){
		Initiating i = new Initiating();
		i.setInitiatingnum(iid);
		return mRepo.findByInitiating(i);
	}
	
	//新增留言
	public MessageArea insertMessasge(UUID uid, Integer num, String message){
		MessageArea m = new MessageArea();
		m.setInitiating(iRepo.findById(num).get());
		m.setUserprofiles(uRepo.findById(uid).get());
		m.setMessage(message);
		m.setPostday(new Date());
		return mRepo.save(m);
	}
	
	//刪除留言
	public void deleteMessage(Integer mid) {
		mRepo.deleteById(mid);
	}
	
	//修改留言
	public MessageArea updateMessage(Integer mid, String message) {
		MessageArea m = mRepo.findById(mid).get();
		m.setMessage(message);
		return mRepo.save(m);
	}
	
}
