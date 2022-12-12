package T4_09._01_job.service;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import T4_09._01_job.dao.JobDAO;
import T4_09._01_job.dao.JobDAOimpl;

import T4_09._01_job.model.JobBean;
import utils.DbUtils;

public class JobServiceDAOImpl implements JobServiceDAO {
	private JobDAO jobDAO = new JobDAOimpl();

	// 秀全部
	@Override
	public List<JobBean> showAllJob() {
		List<JobBean> jb = null;
		try {
			DbUtils.begin();
			jb = jobDAO.selectAll();
			DbUtils.commit();
			return jb;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}

	}

	// 新增職缺
	@Override
	public void addJob(JobBean jobBean) {
		try {
			DbUtils.begin();
			jobDAO.addJob(jobBean);
			DbUtils.commit();
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();

		}
	}

	// 透過rackID秀圖片
	@Override
	public JobBean findImgByRackID(int rackID) {
		try {
			DbUtils.begin();
			JobBean fibr = jobDAO.findImgByRackID(rackID);
			DbUtils.commit();
			return fibr;
		} catch (Exception e) {
			DbUtils.rollbacl();
			return null;
		}

	}

	// 刪除職缺
	@Override
	public void deleteJob(int rackID) {
		try {
			DbUtils.begin();
			jobDAO.deleteJob(rackID);
			DbUtils.commit();
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

	// 改職缺內容

	@Override
	public void updateJob(JobBean jobBean) {
		try {
			DbUtils.begin();
			jobDAO.updateJob(jobBean);
			DbUtils.commit();

		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}


	// 上傳圖片
	@Override
	public Blob fileToBlob(InputStream is, long size) {
		try {
			DbUtils.begin();

			byte[] b = new byte[(int) size];
			SerialBlob sb = null;
			is.read(b);
			sb = new SerialBlob(b);
			DbUtils.commit();
			return sb;

		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}
	}

	// 判斷時間
//	@Override
//	public boolean selectTime(Date rackUp, Date rackDown) {
//		try {
//			DbUtils.begin();
//
//			DbUtils.commit();
//
//		} catch (Exception e) {
//			DbUtils.rollbacl();
//			e.printStackTrace();
//		}
//		return false;
//	}

	// 透過rackID抓一筆資料
	@Override
	public JobBean findBeanByRackID(int rackID) {
		JobBean jBean = null;
		try {
			DbUtils.begin();
			jBean = jobDAO.findBeanByRackID(rackID);
			DbUtils.commit();
			return jBean;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}
	}
	
	//查職缺
	@Override
	public List<JobBean> findJobByJobLike(String job) {
		List<JobBean> jb = null;
		try {
			DbUtils.begin();
			jb = jobDAO.findJobByJobLike(job);
			DbUtils.commit();
			return jb;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		
		}
		
		
	}
	
	//透過會員id找資料
	@Override
	public List<JobBean> findBeanByuID(int uID) {
		List<JobBean> jb = null;
		try {
			DbUtils.begin();
			jb = jobDAO.findBeanByuID(uID);
			DbUtils.commit();
			return jb;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}
	}
	//模糊搜尋全部
	@Override
	public List<JobBean> findJobSelectLike(int uID, int rackID, String job, String salary, int quantity, String place,
			String time, String date, String remark, String rackUp, String rackDown) throws SQLException {
		List<JobBean> jb = null;
		try {
			DbUtils.begin();
			jb = jobDAO.findJobSelectLike(uID,quantity, job, rackDown, quantity, rackDown, rackDown, rackDown, rackDown, rackDown, rackDown);
			DbUtils.commit();
			return jb;
		} catch (Exception e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}

	}
	}
