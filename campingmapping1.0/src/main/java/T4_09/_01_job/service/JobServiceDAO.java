package T4_09._01_job.service;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobServiceDAO {

	// 秀全部
	public List<JobBean> showAllJob();

	//查職缺
	public List<JobBean> findJobByJobLike(String job);
	
	// 新增職缺
	public void addJob(JobBean jobBean);

	// 上傳圖片
	public Blob fileToBlob(InputStream is, long size);
	
	//透過rackID秀圖片
	public JobBean findImgByRackID(int rackID);
	
	// 透過rackID刪除資料
	public void deleteJob(int rackID);

	// 改職缺內容
	public void updateJob(JobBean jobBean);
	
	//透過rackID抓一筆資料
	public JobBean findBeanByRackID(int rackID);
	
	//透過會員id找資料
	public List<JobBean> findBeanByuID(int uID);
	
	//模糊搜尋全部
//	List<JobBean> findJobSelectLike(int uID, int rackID, String job, String salary, int quantity, String place,
//				String time, String date, String remark, String rackUp, String rackDown) throws SQLException;
	
	// 判斷時間
//	public boolean selectTime(Date rackUp, Date rackDown);


}
