package T4_09._01_job.service;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import T4_01.servlerProject.dao.AdminDao;
import T4_01.servlerProject.dao.impl.AdminDaoImpl;
import T4_09._01_job.dao.JobDAO;
import T4_09._01_job.dao.JobDAOimpl;
import T4_09._01_job.dao.jobDAO;
import T4_09._01_job.dao.jobDAOimpl;
import T4_09._01_job.model.JobBean;
import utils.DbUtils;

public class JobServiceImpl implements JobServiceDAO{
	private JobDAO jobDAO = new JobDAOimpl();
	@Override
	public List<JobBean> showAllJob() {
		List<JobBean> jb = null;
		try {
			DbUtils.begin();
			
			jb=jobDAO.selectAll();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		
		return null;
	}

	@Override
	public int addJob(JobBean jobBean) {
		try {
			DbUtils.begin();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int deleteJob(String blank) {
		try {
			DbUtils.begin();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int updateJob(JobBean jobBean) {
		try {
			DbUtils.begin();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public Blob fileToBlob() {
		try {
			DbUtils.begin();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public boolean selectTime(Date rackUp, Date rackDown) {
		try {
			DbUtils.begin();
			DbUtils.commit();
			
		} catch (Exception e) {
		}
		return false;
	}

}
