package com.ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.BaiVietDao;
import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.TrangThaiEntity;

@Service
public class BaiVietService {
	
	@Autowired
	private BaiVietDao dao;
	
	public List<BaiVietEntity> lisBaiVietCD() {
		return dao.getListBVCho();
	}
	
	public BaiVietEntity getbvByID(int id) {
		return dao.getbvByID(id);
	}
	
	public void setTrangThai(BaiVietEntity bv, TrangThaiEntity tt) {
		dao.setTrangThai(bv, tt);
	}
	
	public List<BaiVietEntity> getListBV() {
		return dao.getListBV();
	}
	
	public List<BaiVietEntity> getBVDaDuyet() {
		return dao.getBVDaDuyet();
	}
	
	public void addBaiViet(BaiVietEntity bv) {
		dao.addBaiViet(bv);
	}
	
	public List<BaiVietEntity> getlistMyBV() {
		return dao.getlistMyBV();
	}
	
	public List<BaiVietEntity> searchWithCon(String nganh, String hinhthuc, String khuvuc) {
		return dao.searchWithCon(nganh, hinhthuc, khuvuc);
	}
	
	public void add1View(BaiVietEntity bv) {
		dao.add1View(bv);
	}
	
	public List<BaiVietEntity> selectTop3(String nganh, int exid){
		return dao.selectTop3(nganh, exid);
	}
}
