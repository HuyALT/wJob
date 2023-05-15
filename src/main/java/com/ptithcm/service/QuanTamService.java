package com.ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.QuanTamDao;
import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.QuanTamBaiVietEntity;

@Service
public class QuanTamService {
	
	@Autowired
	private QuanTamDao dao;
	
	public List<QuanTamBaiVietEntity> getlist() {
		return dao.getlist();
	}
	
	public void addLike(BaiVietEntity bv, NguoiDungEntity nd) {
		dao.addlike(bv, nd);
	}
	
	public List<QuanTamBaiVietEntity> getlistByIDBV(int id) {
		return dao.getlistbyIDBV(id);
	}
	
}
