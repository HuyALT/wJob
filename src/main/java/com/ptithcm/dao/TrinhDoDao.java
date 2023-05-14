package com.ptithcm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.TrinhDoEntity;

@Repository("TrinhDoDao")
@Transactional
public class TrinhDoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<TrinhDoEntity> getlist() {
		Session session = sessionFactory.openSession();
		String hql = "From TrinhDoEntity";
		Query qu = session.createQuery(hql);
		return qu.getResultList();
	}
	
	public TrinhDoEntity getTrinhdoByID(int id) {
		Session session = sessionFactory.openSession();
		return session.get(TrinhDoEntity.class, id);
	}
}
