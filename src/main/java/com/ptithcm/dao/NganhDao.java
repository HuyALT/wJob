package com.ptithcm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.NganhEntity;

@Repository("NganhDao")
@Transactional
public class NganhDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<NganhEntity> getlist() {
		Session session = sessionFactory.openSession();
		String hql = "FROM NganhEntity ORDER BY noidung ASC";
		Query qu = session.createQuery(hql);
		return qu.getResultList();
	}
	
	public NganhEntity getNganhByNoiDung(String noidung) {
		Session session = sessionFactory.openSession();
		String hql = "FROM NganhEntity WHERE noidung=:nd";
		Query qu = session.createQuery(hql);
		qu.setParameter("nd", noidung);
		return (NganhEntity) qu.uniqueResult();
	}
	
	public NganhEntity getNganhByID(int id) {
		Session session = sessionFactory.openSession();
		return session.get(NganhEntity.class, id);
	}
}
