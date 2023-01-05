package com.campingmapping.team4.spring.t4_09Job.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;


@Repository
@Transactional
public class JobDAOimpl implements JobDAO {
	@Autowired
	private SessionFactory factory;

	// 新增資料
	@Override
	public void addJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();
		session.save(jobBean);
	}

	// 透過rackID找圖片
	@Override
	public JobBean findImgByRackID(int rackID) {
		Session session = factory.getCurrentSession();
		JobBean result = session.createQuery("from JobBean where rackID = :rid ", JobBean.class)
				.setParameter("rid", rackID).getSingleResult();
		JobBean jobBean = new JobBean();
		jobBean.setImg(result.getImg());
		return jobBean;
	}

	// 透過rackID刪除資料
	@Override
	public void deleteJob(int rackID) {
		Session session = factory.getCurrentSession();
		JobBean jbean = session.get(JobBean.class, rackID);
		if (jbean != null) {
			session.delete(jbean);
		}
	}

	// 透過刊登id更改職缺等
	@Override
	public void updateJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();
		JobBean jbean = session.get(JobBean.class, jobBean.getRackID());
		if (jbean != null) {
			jbean = jobBean;
		}
//		String hql = "update JobBean set uID=?1,job=?2,salary=?3,quantity=?4"
//				+ ",place=?5,time=?6,date=?7,img=?8,remark=?9,rackUp=?10,rackDown=?11"
//				+ " where rackID=?12";	
//		Session session = factory.getCurrentSession();
//		session.createQuery(hql)
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);
//		.setParameter("",);

	}

	// 透過刊登編號找一筆資料
	@Override
	public JobBean findBeanByRackID(int rackID) {
		Session session = factory.getCurrentSession();
		JobBean jbean = session.get(JobBean.class, rackID);

		return jbean;
	}

	// 搜尋全部
	@Override
	public List<JobBean> selectAll() {
		Session session = factory.getCurrentSession();
		Query<JobBean> query = session.createQuery("from JobBean", JobBean.class);
		List<JobBean> result = query.getResultList();
		return result;
	}

	// 透過job搜尋全部職缺
	@Override
	public List<JobBean> findJobByJobLike(String job) {
		Session session = factory.getCurrentSession();

		List<JobBean> result = session.createQuery("from JobBean where job like :j", JobBean.class)
				.setParameter("j", "%" + job + "%").getResultList();
		System.out.println(result);

		return result;
	}

	// 透過會員id找資料
	@Override
	public List<JobBean> findBeanByuID(int uID) {
		Session session = factory.getCurrentSession();

		List<JobBean> result = session.createQuery("from JobBean where uID = :u", JobBean.class)

				.setParameter("u", uID).getResultList();
		return result;
	}

}
