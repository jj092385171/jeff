package com.campingmapping.team4.spring.t4_01Member.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_01Member.model.dao.BaseDao;

import util.HibernateUtils;
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> entityClass;
	private SessionFactory factory;

	public BaseDaoImpl() {
		// 獲得連線
		this.factory = HibernateUtils.getSessionFactory();
		// 獲得父類類型
		ParameterizedType genericSuperclass = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		// 獲得父類上的泛型
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	public Session getCurrentSession() {
		return this.factory.getCurrentSession();
	}

	@Override
	public T insert(T t) {
		if (t != null) {
			return (T) this.getCurrentSession().save(t);
		}
		return null;
	}

	@Override
	public boolean update(T t) {
		if (t != null) {
			this.getCurrentSession().update(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		T t = this.factory.getCurrentSession().get(entityClass, id);
		if (t != null) {
			this.factory.getCurrentSession().delete(t);
			return true;
		}
		return false;
	}

	@Override
	public List<T> getAll() {
		List<T> resultList = this.factory.getCurrentSession()
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();
		return resultList;
	}

	@Override
	public T getById(Serializable id) {
		return this.factory.getCurrentSession().get(entityClass, id);
	}

	@Override
	public List<T> getByMap(Map<String, Object> map) {
		Set<String> set = map.keySet();
		if (set.size() > 0) {
			List<String> list = new ArrayList<String>();
			set.forEach(string -> list.add(string));
			String hql = "from " + entityClass.getSimpleName() + " where ";
			for (int i = 0; i <= list.size() - 1; i++) {
				if (i == 0) {
					hql += list.get(i) + "='" + map.get(list.get(i)) + "'";
				} else {
					hql += " and " + list.get(i) + "='" + map.get(list.get(i))
							+ "'";
				}
			}
			return this.factory.getCurrentSession().createQuery(hql).list();

		}

		return null;
	}

	@Override
	public int countBySql(String sql) {
		NativeQuery<?> q = this.factory.getCurrentSession().createSQLQuery(sql);
		return ((BigInteger) q.uniqueResult()).intValue();
	}

	@Override
	public int executeHql(String hql) {
		Query<T> q = this.factory.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeSql(String sql) {
		NativeQuery<?> q = this.factory.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	// @Override
	// public List<Map<String, Object>> getMapListBySql(String sql) {
	// NativeQuery<?> q = this.factory.getCurrentSession().createSQLQuery(sql);
	// q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	// return (List<Map<String, Object>>) q.list();
	// }

}
