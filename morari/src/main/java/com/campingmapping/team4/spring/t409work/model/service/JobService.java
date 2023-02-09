package com.campingmapping.team4.spring.t409work.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.Dao.repository.JobRepository;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.CampRepository;
import com.campingmapping.team4.spring.t424camp.model.entity.Camp;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobDao;

	@Autowired
	private UserRepository uDao;

	@Autowired
	private CampRepository campDao;

	// 秀全部
	public List<JobBean> findAll() {
		List<JobBean> selectAll = jobDao.findAll();
		return selectAll;
	}

	// 新增職缺
	public JobBean insert(JobBean jBean, UUID u) {
		jBean.setUserprofiles(uDao.findById(u).get());
		Date currentDate = new Date();
		jBean.setRackup(currentDate);
		return jobDao.save(jBean);
	}

	// 改職缺內容
	public JobBean updateJob(JobBean jobBean, Integer rackid) {
		System.out.println(rackid);
		Optional<JobBean> result = jobDao.findById(rackid);
		if (result.isPresent()) {
			JobBean jBean = result.get();
			// 將前端傳進來的jobBean的值複製到jBean
			jBean.setJob(jobBean.getJob());
			jBean.setDate(jobBean.getDate());
			jBean.setRemark(jobBean.getRemark());
			jBean.setSalary(jobBean.getSalary());
			jBean.setTime(jobBean.getTime());
			jBean.setQuantity(jobBean.getQuantity());

			jBean.setRackup(result.get().getRackup());
//		        jBean.setUserprofiles(result.get().getUserprofiles().getUid());	        
			// 使用save更新資料庫中的資料
			return jobDao.save(jBean);
		}
		// 找不到對應的資料
		return null;
	}

	// 刪除職缺
	public void deleteById(int rackID) {
		jobDao.deleteById(rackID);
	}

	// 透過rackID抓一筆資料
	public JobBean findById(Integer rackID) {
		Optional<JobBean> result = jobDao.findById(rackID);
		JobBean r = null;
		if (result.isPresent()) {
			r = result.get();
		}
		return r;
	}

	// 查職缺
	public List<JobBean> findByJobisLike(String job) {
		return jobDao.findByJobisLike(job);
	}

	// 透過會員id找資料
	public List<JobBean> findUid(UUID uid) {

		Collection<JobBean> job = uDao.findById(uid).get().getJob();
		ArrayList<JobBean> arrayList = new ArrayList<JobBean>(job);
		return arrayList;
	}

	// 透過uid搜尋camp的東西
	public ArrayList<Camp> findUUid(UUID uid) {
		Collection<Camp> camp = uDao.findById(uid).get().getCamp();
		ArrayList<Camp> arrayList = new ArrayList<Camp>(camp);
		return arrayList;
	}

	// 透過campid搜尋camp的東西
	public Camp findCampid(Integer campid) {
		Camp camp = campDao.findById(campid).get();
		return camp;
	}

	// 存履歷到jobs裡
	public JobBean save(JobBean job) {
		return jobDao.save(job);
	}

}