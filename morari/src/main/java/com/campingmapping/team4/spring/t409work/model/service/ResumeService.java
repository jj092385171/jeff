package com.campingmapping.team4.spring.t409work.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	public ResumeBean insert(ResumeBean rBean, Integer u, Integer rackid) {
		rBean.setUserprofiles(uDao.findById(u).get());
		rBean.setJob(jDao.findById(rackid).get());
		return reDao.save(rBean);
	}
	
	// 刪除履歷
	public void deleteById(int number) {
		reDao.deleteById(number);
	}
	
	// 改履歷內容
	public ResumeBean updateJob(ResumeBean rBean) {
		return reDao.save(rBean);
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
	public List<ResumeBean> findUid(Integer uid) {

		UserProfiles findById = uDao.findById(uid).get();
		Collection<ResumeBean> resume = findById.getResume();
		ArrayList<ResumeBean> arrayList = new ArrayList<ResumeBean>(resume);
		return arrayList;
	}
	
	// 透過rackid找應徵的履歷
	public List<ResumeBean> findRid(Integer rackid ) {
		
		JobBean findById = jDao.findById(rackid).get();
		Collection<ResumeBean> resume = findById.getResume();
		ArrayList<ResumeBean> arrayList = new ArrayList<ResumeBean>(resume);
		return arrayList;
	}
}
