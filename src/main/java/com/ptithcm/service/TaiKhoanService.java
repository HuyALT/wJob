package com.ptithcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.TaiKhoanDao;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.TaiKhoanEntity;

@Service
public class TaiKhoanService {
	
	@Autowired
	private TaiKhoanDao dao;
	
	public boolean Dangky(TaiKhoanEntity tk) {
		return dao.DangKy(tk);
	}
	
	public NguoiDungEntity getNDlogin() {
		return dao.getNDLogin();
	}
}
