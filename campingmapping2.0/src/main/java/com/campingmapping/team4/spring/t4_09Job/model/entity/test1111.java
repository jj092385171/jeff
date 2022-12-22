package com.campingmapping.team4.spring.t4_09Job.model.entity;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_09Job.model.dao.JobDAOimpl;

import util.HibernateUtils;

public class test1111 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.beginTransaction();

			JobDAOimpl jobDAOimpl = new JobDAOimpl();
			List<JobBean> selectAll = jobDAOimpl.selectAll();

			for (JobBean emp : selectAll) {
				System.out.println(emp);
			}
		
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			currentSession.getTransaction().rollback();
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}
