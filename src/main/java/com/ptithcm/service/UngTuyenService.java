package com.ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.UngTuyenDao;
import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.UngTuyenEntity;

@Service
public class UngTuyenService {
	
	@Autowired
	private UngTuyenDao dao;
	
	public List<UngTuyenEntity> getlist() {
		return dao.getlist();
	}
	
	public void addLike(BaiVietEntity bv, NguoiDungEntity nd) {
		dao.addlike(bv, nd);
	}
	
	public List<UngTuyenEntity> getlistByIDBV(int id) {
		return dao.getlistbyIDBV(id);
	}
	
}
