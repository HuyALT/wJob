package com.ptithcm.dao;

import java.util.ArrayList;
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
import com.ptithcm.entity.TrangThaiEntity;
import com.ptithcm.service.TaiKhoanService;

@Repository("BaiVietDao")
@Transactional
public class BaiVietDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private TaiKhoanService tkService;
	
	
	public List<BaiVietEntity> getListBVCho() {
		Session session = sessionFactory.openSession();
		String hql = "FROM BaiVietEntity WHERE ttEntity.id = 1";
		Query qu = session.createQuery(hql);
		
		List<BaiVietEntity> lbv = qu.getResultList();
		
		return lbv;
	}
	
	public List<BaiVietEntity> getBVDaDuyet() {
		Session session = sessionFactory.openSession();
		String hql = "FROM BaiVietEntity WHERE ttEntity.id = 2 ORDER BY ngaykt DESC";
		Query qu = session.createQuery(hql);
		
		List<BaiVietEntity> lbv = qu.getResultList();
		
		return lbv;
	}
	
	public List<BaiVietEntity> getlistMyBV() {
		Session session = sessionFactory.openSession();
		NguoiDungEntity nd = tkService.getNDlogin();
		String hql = "FROM BaiVietEntity WHERE ndEntity.id = :id ORDER BY ngaykt DESC";
		Query qu = session.createQuery(hql);
		qu.setParameter("id", nd.getId());
		return qu.getResultList();
	}
	
	public List<BaiVietEntity> getListBV() {
		Session session = sessionFactory.openSession();
		String hql = "FROM BaiVietEntity";
		Query qu = session.createQuery(hql);
		
		List<BaiVietEntity> lbv = qu.getResultList();
		
		return lbv;
	}
	
	public BaiVietEntity getbvByID(int id) {
		Session session = sessionFactory.openSession();
		
		return (BaiVietEntity) session.get(BaiVietEntity.class, id);
	}
	
	public void setTrangThai(BaiVietEntity bv, TrangThaiEntity tt) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		BaiVietEntity bvht = bv;
		bvht.setTtEntity(tt);
		
		try {
			session.merge(bvht);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void addBaiViet(BaiVietEntity bv) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(bv);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
	
	}
	
	public List<BaiVietEntity> searchWithCon(String nganh, String hinhthuc, String khuvuc) {
		Session session = sessionFactory.openSession();
		String hql = "FROM BaiVietEntity WHERE ttEntity.id=2 AND nganhEntity.noidung LIKE :nganh AND loaicv LIKE :hinhthuc AND khuvuc LIKE :khuvuc ORDER BY ngaykt DESC";
		Query qu = session.createQuery(hql);
		if (nganh.isEmpty()) {
			qu.setParameter("nganh", "%");
		}else {
			qu.setParameter("nganh", nganh);
		}
		
		if (hinhthuc.isEmpty()) {
			qu.setParameter("hinhthuc", "%");
		}else {
			qu.setParameter("hinhthuc","%" + hinhthuc + "%");
		}
		
		if (khuvuc.isEmpty()) {
			qu.setParameter("khuvuc", "%");
		}else {
			qu.setParameter("khuvuc",khuvuc);
		}
		return qu.getResultList();
	}
	
	public List<BaiVietEntity> selectTop3(String nganh, int exceptid){
		Session session = sessionFactory.openSession();
		String hql = "FROM BaiVietEntity WHERE ttEntity.id=2 AND nganhEntity.noidung = :nganh AND id!=:exid ORDER BY ngaykt DESC";
		Query qu = session.createQuery(hql);
		qu.setParameter("nganh", nganh);
		qu.setParameter("exid", exceptid);
		
		List<BaiVietEntity> lres = qu.getResultList();
		
		List<BaiVietEntity> lt3 = new ArrayList<>();
		if (lres.size()>3) {
			lt3.add(lres.get(0));
			lt3.add(lres.get(1));
			lt3.add(lres.get(2));
			return lt3;
		}
		
		return lres;
	}
	
	public void add1View(BaiVietEntity bv) {
		Session session = sessionFactory.openSession();
		bv.setLuotxem(bv.getLuotxem()+1);
		Transaction t = session.beginTransaction();
		
		try {
			session.merge(bv);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
		
	}
}
