package T4_09._01_job.dao;

import java.util.List;

import T4_09._01_job.model.JobBean;

public interface jobDAO {
	
	//查職缺
	public JobBean selectJob(String blank);
	//新增職缺
	public void addJob(JobBean jobBean );
	//刪除職缺
	public void deleteJob(String blank);
	//改職缺內容
	public void updateJob(JobBean jobBean);
	
	public List<JobBean>selectAll();
	
	
	
}
