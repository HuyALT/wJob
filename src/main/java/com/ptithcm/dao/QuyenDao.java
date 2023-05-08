package com.ptithcm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.QuyenEntity;

@Repository("QuyenDao")
@Transactional
public class QuyenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public QuyenEntity getRoleB() {
		Session session = sessionFactory.openSession();
		return (QuyenEntity) session.get(QuyenEntity.class, "B");
	}
	
	public QuyenEntity getRoleC() {
		Session session = sessionFactory.openSession();
		return (QuyenEntity) session.get(QuyenEntity.class, "C");
	}
}
