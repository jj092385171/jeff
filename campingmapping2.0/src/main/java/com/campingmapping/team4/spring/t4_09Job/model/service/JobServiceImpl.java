package com.campingmapping.team4.spring.t4_09Job.model.service;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_09Job.model.dao.JobDAO;
import com.campingmapping.team4.spring.t4_09Job.model.dao.JobDAOimpl;
import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;

import util.HibernateUtils;


public class JobServiceImpl implements JobService {
	private JobDAO jobDAO = new JobDAOimpl();
	
	private SessionFactory factory;

	public JobServiceImpl() {
		this.factory =  HibernateUtils.getSessionFactory();
	}

	// 秀全部
	@Override
	public List<JobBean> showAllJob() {
		List<JobBean> jb = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jb = jobDAO.selectAll();
			session.getTransaction().commit();
			return jb;
		} catch (Exception  e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	// 新增職缺
	@Override
	public void addJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jobDAO.addJob(jobBean);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	// 透過rackID秀圖片
	@Override
	public JobBean findImgByRackID(int rackID) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			JobBean fibr = jobDAO.findImgByRackID(rackID);
			session.getTransaction().commit();
			return fibr;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}

	}

	// 刪除職缺
	@Override
	public void deleteJob(int rackID) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jobDAO.deleteJob(rackID);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// 改職缺內容

	@Override
	public void updateJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jobDAO.updateJob(jobBean);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	// 上傳圖片
	@Override
	public Blob fileToBlob(InputStream is, long size) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			byte[] b = new byte[(int) size];
			SerialBlob sb = null;
			is.read(b);
			sb = new SerialBlob(b);
			session.getTransaction().commit();
			return sb;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 透過rackID抓一筆資料
	@Override
	public JobBean findBeanByRackID(int rackID) {
		JobBean jBean = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jBean = jobDAO.findBeanByRackID(rackID);
			session.getTransaction().commit();
			return jBean;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 查職缺
	@Override
	public List<JobBean> findJobByJobLike(String job) {
		List<JobBean> jb = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jb = jobDAO.findJobByJobLike(job);
			session.getTransaction().commit();
			return jb;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;

		}

	}

	// 透過會員id找資料
	@Override
	public List<JobBean> findBeanByuID(int uID) {
		List<JobBean> jb = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			jb = jobDAO.findBeanByuID(uID);
			session.getTransaction().commit();
			return jb;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	// 判斷時間
//		@Override
//		public boolean selectTime(Date rackUp, Date rackDown) {
//			try {
//				DbUtils.begin();
	//
//				DbUtils.commit();
	//
//			} catch (Exception e) {
//				DbUtils.rollbacl();
//				e.printStackTrace();
//			}
//			return false;
//		}
}
