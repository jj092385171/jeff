package T4_09._01_job.dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import T4_09._01_job.model.JobBean;

public interface JobDAO {
	
	//查職缺
	public JobBean selectJob(String blank);
	//新增職缺
	public int addJob(JobBean jobBean);
	//刪除職缺
	public int deleteJob(String blank);
	//改職缺內容
	public int updateJob(JobBean jobBean);
	//找全部
	public List<JobBean> selectAll();
	

	 
	
	
}
