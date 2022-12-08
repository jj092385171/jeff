package T4_09._01_job.service;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobServiceDAO {

	// 秀全部
	public List<JobBean> showAllJob();

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

	// 判斷時間
	public boolean selectTime(Date rackUp, Date rackDown);


}
