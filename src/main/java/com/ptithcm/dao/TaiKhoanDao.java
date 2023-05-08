package com.ptithcm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.TaiKhoanEntity;

@Repository("TaiKhoanDao")
@Transactional
public class TaiKhoanDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean DangKy(TaiKhoanEntity tk)
	{
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(tk);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
	
	public NguoiDungEntity getNDLogin() {
		Session session = sessionFactory.openSession();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name;
		name = auth.getName();
		TaiKhoanEntity tk = session.get(TaiKhoanEntity.class, name);
		return tk.getNdEntity();
	}
	
	public boolean checkUserNameExist(String username) {
		Session session = sessionFactory.openSession();
		TaiKhoanEntity tk = session.get(TaiKhoanEntity.class, username);
		
		return tk==null?false:true;
	}
}
