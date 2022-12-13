package T4_09._01_job.dao;

import java.sql.SQLException;

import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobDAO {

	// 查職缺
	public List<JobBean> findJobByJobLike(String job) throws SQLException;

	// 新增職缺
	public void addJob(JobBean jobBean) throws SQLException;

	// 找全部
	public List<JobBean> selectAll() throws SQLException;

	// 改職缺內容
	public void updateJob(JobBean jobBean);

	// 透過rackID刪除資料
	public void deleteJob(int rackID) throws SQLException;

	// 透過rackID找圖片
	public JobBean findImgByRackID(int rackID) throws SQLException;

	// 透過rackID抓一筆資料
	public JobBean findBeanByRackID(int rackID) throws SQLException;

	// 透過會員id找資料
	public List<JobBean> findBeanByuID(int uID) throws SQLException;

//	//模糊搜尋全部
//	List<JobBean> findJobSelectLike(int uID, int rackID, String job, String salary, int quantity, String place,
//			String time, String date, String remark, String rackUp, String rackDown) throws SQLException;

}
