package com.campingmapping.team4.spring.t409work.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.Dao.repository.JobRepository;
import com.campingmapping.team4.spring.t409work.model.Dao.repository.ResumeRepository;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;

@Service
@Transactional
public class ResumeService {

	@Autowired
	private ResumeRepository reDao;

	@Autowired
	private UserRepository uDao;
	
	@Autowired
	private JobRepository jDao;

	// 秀全部
	public List<ResumeBean> findAll() {
		List<ResumeBean> selectAll = reDao.findAll();
		return selectAll;
	}

	// 新增履歷
	public ResumeBean insert(ResumeBean rBean, UUID u, Integer rackid) {
		rBean.setUserprofiles(uDao.findById(u).get());
		rBean.setJob(jDao.findById(rackid).get());
		Date currentDate = new Date();
		rBean.setPtime(currentDate);
		System.out.println("rBean="+rBean);
		return reDao.save(rBean);
	}
	
	// 刪除履歷
	public void deleteById(int number) {
		reDao.deleteById(number);
	}
	
	// 改履歷內容
	public ResumeBean updateJob(ResumeBean rBean,Integer number) {
		Optional<ResumeBean> result = reDao.findById(number);
		if (result.isPresent()) {
			ResumeBean resumeBean = result.get();
	        // 將前端傳進來的rBean的值複製到resumeBean
//			resumeBean.setJob(result.get().getJob().getRackid());
			resumeBean.setWork(rBean.getWork());
			resumeBean.setName(rBean.getName());
			resumeBean.setAge(rBean.getAge());
			resumeBean.setGender(rBean.getGender());
			resumeBean.setMail(rBean.getMail());
			resumeBean.setPhone(rBean.getPhone());
			resumeBean.setEducational(rBean.getEducational());
			resumeBean.setExperience(rBean.getExperience());
			
			resumeBean.setPtime(result.get().getPtime());
//	        jBean.setUserprofiles(result.get().getUserprofiles().getUid());	        
	        // 使用save更新資料庫中的資料
			return reDao.save(resumeBean);
	    }
	    //找不到對應的資料
	    return null;
	}

	// 透過number抓一筆資料(有需要嗎?)
	public ResumeBean findById(Integer number) {
		Optional<ResumeBean> result = reDao.findById(number);
		ResumeBean r = null;
		if (result.isPresent()) {
			r = result.get();
		}
		return r;
	}

	// 透過會員id找履歷
	public List<ResumeBean> findUid(UUID uid) {

		UserProfiles findById = uDao.findById(uid).get();
		Collection<ResumeBean> resume = findById.getResume();
		ArrayList<ResumeBean> arrayList = new ArrayList<ResumeBean>(resume);
		return arrayList;
	}
	
	// 透過rackid找應徵的履歷
	public List<ResumeBean> findRid(Integer rackid) {
		
		JobBean findById = jDao.findById(rackid).get();
		Collection<ResumeBean> resume = findById.getResume();
		ArrayList<ResumeBean> arrayList = new ArrayList<ResumeBean>(resume);
		return arrayList;
	}
}
