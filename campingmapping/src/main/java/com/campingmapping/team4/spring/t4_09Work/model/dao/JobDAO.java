package com.campingmapping.team4.spring.t4_09Work.model.dao;

import java.util.List;

import com.campingmapping.team4.spring.t4_09Work.model.entity.JobBean;

public interface JobDAO {

	// 查職缺
	public List<JobBean> findJobByJobLike(String job);

	// 新增職缺
	public void addJob(JobBean jobBean);

	// 找全部
	public List<JobBean> selectAll();

	// 改職缺內容
	public void updateJob(JobBean jobBean);

	// 透過rackID刪除資料
	public void deleteJob(int rackID);

	// 透過rackID找圖片
	public JobBean findImgByRackID(int rackID);

	// 透過rackID抓一筆資料
	public JobBean findBeanByRackID(int rackID);

	// 透過會員id找資料
	public List<JobBean> findBeanByuID(int uID);

}
