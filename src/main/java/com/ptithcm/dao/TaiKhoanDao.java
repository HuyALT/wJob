package com.ptithcm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public TaiKhoanEntity getTKLogin() {
		Session session = sessionFactory.openSession();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name;
		name = auth.getName();
		TaiKhoanEntity tk = session.get(TaiKhoanEntity.class, name);
		return tk;
	}
	
	public void changeStatusAccount(TaiKhoanEntity tk) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (tk.getTrangthai()) {
			tk.setTrangthai(false);
		}
		else {
			tk.setTrangthai(true);
		}
		try {
			session.update(tk);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}
	
	public TaiKhoanEntity getTKByUsername(String username) {
		Session session = sessionFactory.openSession();
		return session.get(TaiKhoanEntity.class, username);
	}
	
	public boolean checkUserNameExist(String username) {
		Session session = sessionFactory.openSession();
		TaiKhoanEntity tk = session.get(TaiKhoanEntity.class, username);
		
		return tk==null?false:true;
	}
	
	public List<TaiKhoanEntity> getListTaiKhoan() {
		Session session = sessionFactory.openSession();
		String hql = "From TaiKhoanEntity WHERE quEntity.maQuyen !='A'";
		Query qu = session.createQuery(hql);
		return qu.getResultList();
	}
	
	public void ChangePassword(TaiKhoanEntity tk, String rawpassword) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		tk.setPassword(encode.encode(rawpassword));
		
		try {
			session.update(tk);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		
		
	}
}
