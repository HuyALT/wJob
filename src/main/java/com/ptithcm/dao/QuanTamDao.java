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
import com.ptithcm.entity.QuanTamBaiVietEntity;
import com.ptithcm.entity.combinekey.QuanTamBVKey;

@Repository("QuanTamDao")
@Transactional
public class QuanTamDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<QuanTamBaiVietEntity> getlist() {
		Session session = sessionFactory.openSession();
		String hql = "FROM QuanTamBaiVietEntity";
		Query qu  = session.createQuery(hql);
		return qu.getResultList();
	}
	
	public List<QuanTamBaiVietEntity> getlistbyIDBV(int id) {
		Session session = sessionFactory.openSession();
		String hql = "FROM QuanTamBaiVietEntity WHERE key.idbv=:id";
		Query qu  = session.createQuery(hql);
		qu.setParameter("id", id);
		return qu.getResultList();
	}
	
	public void addlike(BaiVietEntity bv, NguoiDungEntity nd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		QuanTamBaiVietEntity qtbv = new QuanTamBaiVietEntity();
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
