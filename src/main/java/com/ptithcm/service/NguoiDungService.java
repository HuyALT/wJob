package com.ptithcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.NguoiDungDao;
import com.ptithcm.entity.NguoiDungEntity;

@Service
public class NguoiDungService {
	
	@Autowired
	private NguoiDungDao dao;
	
	public boolean addNguoiDung(NguoiDungEntity nd) {
		return dao.addNguoiDung(nd);
	}
	
	public boolean changeInfomation(NguoiDungEntity nd) {
		return dao.changeInfomation(nd);
	}
	
	public NguoiDungEntity getNguoiDungByID(int id) {
		return dao.getNguoiDungbyID(id);
	}
}
