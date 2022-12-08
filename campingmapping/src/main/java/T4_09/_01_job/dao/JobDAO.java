package T4_09._01_job.dao;


import java.sql.SQLException;

import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobDAO {
	
	//查職缺
	public JobBean selectJob(String blank);
	//新增職缺
	public void addJob(JobBean jobBean) throws SQLException;
	//透過rackID刪除資料
	public void deleteJob(int rackID) throws SQLException;
	//改職缺內容
	public void updateJob(JobBean jobBean);
	//找全部
	public List<JobBean> selectAll() throws SQLException;
	//透過rackID找圖片
	public JobBean findImgByRackID(int rackID) throws SQLException;

	 
	
	
}
