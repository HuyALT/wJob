package com.ptithcm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.NguoiDungEntity;

@Repository("NguoiDungDao")
@Transactional
public class NguoiDungDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addNguoiDung(NguoiDungEntity nd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(nd);
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	public boolean changeInfomation(NguoiDungEntity nd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.merge(nd);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			session.close();
		}
	}
}
