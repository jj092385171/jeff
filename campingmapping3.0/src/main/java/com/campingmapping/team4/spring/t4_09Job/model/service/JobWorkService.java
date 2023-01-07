package com.campingmapping.team4.spring.t4_09Job.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_09Job.model.dao.JobWorkDao;
import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;

@Service
@Transactional
public class JobWorkService {

	@Autowired
	private JobWorkDao jobDao;

	// 秀全部
	public List<JobWorkBean> showAllJob() {
		List<JobWorkBean> selectAll = jobDao.selectAll();
//		System.out.println(selectAll);
		return selectAll;	
	}

	// 新增職缺
	public void addJob(JobWorkBean jobBean) {
		jobDao.addJob(jobBean);
	}

	// 透過rackID秀圖片
	public JobWorkBean findImgByRackID(int rackID) {
		return jobDao.findImgByRackID(rackID);	 
	}

	// 刪除職缺
	public void deleteJob(int rackID) {
		jobDao.deleteJob(rackID);
	}

	// 改職缺內容
	public void updateJob(JobWorkBean jobBean) {
		jobDao.updateJob(jobBean);
	}

	// 上傳圖片
	public Blob fileToBlob(InputStream is, long size) throws SerialException, SQLException, IOException {
		byte[] b = new byte[(int) size];
		is.read(b);
		return new SerialBlob(b);
	}

	// 透過rackID抓一筆資料
	public JobWorkBean findBeanByRackID(int rackID) {
		return jobDao.findBeanByRackID(rackID);
	}

	// 查職缺
	public List<JobWorkBean> findJobByJobLike(String job) {
		return jobDao.findJobByJobLike(job);
	}

	// 透過會員id找資料
	public List<JobWorkBean> findBeanByuID(int uID) {
		return jobDao.findBeanByuID(uID);
	}
}
