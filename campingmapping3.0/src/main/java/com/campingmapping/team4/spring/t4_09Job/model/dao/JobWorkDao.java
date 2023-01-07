package com.campingmapping.team4.spring.t4_09Job.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;

@Repository
@Transactional
public class JobWorkDao {
	@Autowired
	private SessionFactory factory;

	// 新增資料
	public void addJob(JobWorkBean jobBean) {
		Session session = factory.openSession();
		session.save(jobBean);
		session.close();
	}

	// 透過rackID找圖片
	public JobWorkBean findImgByRackID(int rackID) {
		Session session = factory.openSession();
		JobWorkBean result = session.createQuery("from JobWorkBean where rackID = :rid ", JobWorkBean.class)
				.setParameter("rid", rackID).getSingleResult();
		JobWorkBean jobBean = new JobWorkBean();
		jobBean.setImg(result.getImg());
		session.close();
		return jobBean;
	}

	// 透過rackID刪除資料
	public void deleteJob(int rackID) {
		Session session = factory.openSession();
		JobWorkBean jbean = session.get(JobWorkBean.class, rackID);
		System.out.println(jbean);
		if (jbean != null) {
			session.delete(jbean);
			//一定要加這行
			session.flush();
			session.close();
		}
		session.close();
	}

	// 透過刊登id更改職缺等
	public void updateJob(JobWorkBean jobBean) {
		Session session = factory.openSession();
		JobWorkBean jbean = session.get(JobWorkBean.class, jobBean.getRackID());
		jbean.setuID(jobBean.getuID());
		jbean.setJob(jobBean.getJob());
		jbean.setPlace(jobBean.getPlace());
		jbean.setQuantity(jobBean.getQuantity());
		jbean.setRackDown(jobBean.getRackDown());
		jbean.setRackUp(jobBean.getRackUp());
		jbean.setRemark(jobBean.getRemark());
		jbean.setSalary(jobBean.getSalary());
		jbean.setImg(jobBean.getImg());
		jbean.setDate(jobBean.getDate());
		jbean.setTime(jobBean.getTime());
		session.close();
	}

	// 透過刊登編號找一筆資料
	public JobWorkBean findBeanByRackID(int rackID) {
		Session session = factory.openSession();
		JobWorkBean jbean = session.get(JobWorkBean.class, rackID);
		session.close();
		return jbean;
	}

	// 搜尋全部
	public List<JobWorkBean> selectAll() {
		Session session = factory.openSession();
		Query<JobWorkBean> query = session.createQuery("from JobWorkBean", JobWorkBean.class);
		List<JobWorkBean> result = query.getResultList();
		session.close();
		return result;
	}

	// 透過job搜尋全部職缺
	public List<JobWorkBean> findJobByJobLike(String job) {
		Session session = factory.openSession();
		List<JobWorkBean> result = session.createQuery("from JobWorkBean where job like :j", JobWorkBean.class)
				.setParameter("j", "%" + job + "%").getResultList();
		System.out.println(result);
		session.close();
		return result;
	}

	// 透過會員id找資料
	public List<JobWorkBean> findBeanByuID(int uID) {
		Session session = factory.openSession();

		List<JobWorkBean> result = session.createQuery("from JobWorkBean where uID = :u", JobWorkBean.class)
				.setParameter("u", uID).getResultList();
		session.close();
		return result;
	}

}
