package com.campingmapping.team4.spring.t4_01Member.model;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.Ccccdao;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Cccc;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

		
//			MemberDaoImpl testDao = new MemberDaoImpl();
//			Member byId = testDao.getById(1);
//			System.out.println(byId.toString());
//			List<Member> all = testDao.getAll();
//			ListIterator<Member> listIterator = all.listIterator();
//			listIterator.forEachRemaining(m->System.out.println(m));

			Ccccdao ccccdao = new Ccccdao();
			List<Cccc> all = ccccdao.getAll();
			ListIterator<Cccc> listIterator = all.listIterator();
			listIterator.forEachRemaining(s ->System.out.println(s.toString()));

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}
