package com.ptithcm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.UngTuyenEntity;
import com.ptithcm.entity.combinekey.QuanTamBVKey;

@Repository("QuanTamDao")
@Transactional
public class UngTuyenDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UngTuyenEntity> getlist() {
		Session session = sessionFactory.openSession();
		String hql = "FROM UngTuyenEntity";
		Query qu  = session.createQuery(hql);
		return qu.getResultList();
	}
	
	public List<UngTuyenEntity> getlistbyIDBV(int id) {
		Session session = sessionFactory.openSession();
		String hql = "FROM UngTuyenEntity WHERE key.idbv=:id";
		Query qu  = session.createQuery(hql);
		qu.setParameter("id", id);
		return qu.getResultList();
	}
	
	public void addlike(BaiVietEntity bv, NguoiDungEntity nd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		UngTuyenEntity qtbv = new UngTuyenEntity();
		QuanTamBVKey key = new QuanTamBVKey();
		
		key.setIdbv(bv.getId());
		key.setIdnd(nd.getId());
		
		qtbv.setKey(key);
		qtbv.setBvEntity(bv);
		qtbv.setNdEntity(nd);
		
		try {
			session.save(qtbv);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
	}
	
}
