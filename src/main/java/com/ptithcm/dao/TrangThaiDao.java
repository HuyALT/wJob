package com.ptithcm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.TrangThaiEntity;

@Repository("TrangThaiDao")
@Transactional
public class TrangThaiDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TrangThaiEntity getID1() {
		Session session = sessionFactory.openSession();
		return session.get(TrangThaiEntity.class, 1);
	}
	
	public TrangThaiEntity getID2() {
		Session session = sessionFactory.openSession();
		return session.get(TrangThaiEntity.class, 2);
	}
	
	public TrangThaiEntity getID3() {
		Session session = sessionFactory.openSession();
		return session.get(TrangThaiEntity.class, 3);
	}
	
	public TrangThaiEntity getID4() {
		Session session = sessionFactory.openSession();
		return session.get(TrangThaiEntity.class, 4);
	}
}
