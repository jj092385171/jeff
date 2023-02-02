package com.campingmapping.team4.spring.t409work.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.Dao.repository.JobRepository;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobDao;

	@Autowired
	private UserRepository uDao;

	// 秀全部
	public List<JobBean> findAll() {
		List<JobBean> selectAll = jobDao.findAll();
		return selectAll;
	}

	// 新增職缺
	public JobBean insert(JobBean jBean, UUID u) {
		jBean.setUserprofiles(uDao.findById(u).get());
		Date currentDate = new Date();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		jBean.setRackup(sd.format(currentDate));
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
			jBean.setPlace(jobBean.getPlace());
			jBean.setRemark(jobBean.getRemark());
			jBean.setSalary(jobBean.getSalary());
			jBean.setTime(jobBean.getTime());
			jBean.setImg(jobBean.getImg());
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

	// 查職缺+uid
//	public List<JobBean> findByUidAndJobisLike(Integer uid, String job) {
//		return jobDao.findByUidAndJobisLike(1, job);
//	}

	// 透過會員id找資料
	public List<JobBean> findUid(UUID uid) {

		UserProfiles findById = uDao.findById(uid).get();
		Collection<JobBean> job = findById.getJob();
		ArrayList<JobBean> arrayList = new ArrayList<JobBean>(job);
		return arrayList;
	}

	// 圖片轉blob
	public Blob fileToBlob(InputStream is, long size) throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		is.read(b);
		return new SerialBlob(b);
	}

	public Blob fileToBlob(MultipartFile photo) throws IOException, SQLException {
		InputStream is = photo.getInputStream();
		long size = photo.getSize();
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	// 透過rackID秀圖片
//	public JobBean findImgByRackID(int rackID) {
//		return jobDao.findImgByRackID(rackID);	 
//	}
}