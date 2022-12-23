package com.campingmapping.team4.spring.t4_09Job.model.entity;

<<<<<<< HEAD
import java.util.Iterator;
=======
>>>>>>> 09
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_09Job.model.dao.JobDAOimpl;

import util.HibernateUtils;

public class test1111 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
<<<<<<< HEAD
=======
		
>>>>>>> 09
		try {
			currentSession.beginTransaction();

			JobDAOimpl jobDAOimpl = new JobDAOimpl();
			List<JobBean> selectAll = jobDAOimpl.selectAll();

<<<<<<< HEAD
			Iterator<JobBean> iterator = selectAll.iterator();
			iterator.forEachRemaining(s -> System.out.println(s.toString()));
//		
=======
			for (JobBean emp : selectAll) {
				System.out.println(emp);
			}
>>>>>>> 09
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
