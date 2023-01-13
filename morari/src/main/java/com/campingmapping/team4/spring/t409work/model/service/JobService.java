package com.campingmapping.team4.spring.t409work.model.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.Dao.repository.JobRepository;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;


@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobDao;

	// 秀全部
	public List<JobBean> findAll() {
		List<JobBean> selectAll = jobDao.findAll();
		return selectAll;	
	}

	// 新增職缺
	public void insert(JobBean jBean) {
		jobDao.save(jBean);
	}

	// 透過rackID秀圖片
//	public JobBean findImgByRackID(int rackID) {
//		return jobDao.findImgByRackID(rackID);	 
//	}

	// 刪除職缺
	public void deleteById(int rackID) {
		jobDao.deleteById(rackID);
	}

	// 改職缺內容
	public void updateJob(JobBean jobBean) {
		jobDao.save(jobBean);
	}

	// 載入圖片
//	public Blob fileToBlob(InputStream is, long size) throws SerialException, SQLException, IOException {
//		return jobDao.fileToBlob(is, size);
//	}

	// 透過rackID抓一筆資料
	public JobBean findById(Integer rackID) {
		Optional<JobBean> result = jobDao.findById(rackID);
		JobBean r = null;
		if(result.isPresent()) {
			r = result.get();
		}	
		return r;	
	}

	// 查職缺
	public List<JobBean> findByJobisLike(String job) {
		return jobDao.findByJobisLike(job);
	}

	// 透過會員id找資料
	public List<JobBean> findByUid(UserProfiles userprofiles ) {
		return jobDao.findByUid(userprofiles);
	}
}