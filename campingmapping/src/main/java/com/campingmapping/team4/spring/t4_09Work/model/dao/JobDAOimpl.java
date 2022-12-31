package com.campingmapping.team4.spring.t4_09Work.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_09Work.model.entity.JobBean;

import util.HibernateUtils;

public class JobDAOimpl implements JobDAO {

	private SessionFactory factory;

	public JobDAOimpl() {
		this.factory = HibernateUtils.getSessionFactory();
	}

	// 新增資料
	@Override
	public void addJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();

		System.out.println(jobBean);

		session.save(jobBean);

	}

	// 透過rackID找圖片
	@Override
	public JobBean findImgByRackID(int rackID) {
		Session session = factory.getCurrentSession();
		JobBean result = session.createQuery("from JobBean where rackID = :rid ", JobBean.class)
				.setParameter("rid", rackID)
				.getSingleResult();
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

	// 透過rackID更改職缺等
	@Override
	public void updateJob(JobBean jobBean) {
		Session session = factory.getCurrentSession();
		JobBean jbean = session.get(JobBean.class, jobBean.getRackID());
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

	}

	// 透過rackID找一筆資料
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
				.setParameter("j", "%" + job + "%")
				.getResultList();

		return result;
	}

	// 透過uID找資料
	@Override
	public List<JobBean> findBeanByuID(int uID) {
		Session session = factory.getCurrentSession();

		List<JobBean> result = session.createQuery("from JobBean where uID = :u", JobBean.class)

				.setParameter("u", uID)
				.getResultList();
		return result;
	}

}
