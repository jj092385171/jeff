package T4_09._01_job.service;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobServiceDAO {

	// 秀全部
	public List<JobBean> showAllJob();

	// 新增職缺
	public int addJob(JobBean jobBean);

	// 刪除職缺
	public int deleteJob(String blank);

	// 改職缺內容
	public int updateJob(JobBean jobBean);

	// 上傳圖片
	public Blob fileToBlob();

	// 判斷時間
	public boolean selectTime(Date rackUp, Date rackDown);

}
