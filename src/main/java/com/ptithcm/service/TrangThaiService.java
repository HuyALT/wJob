package com.ptithcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.TrangThaiDao;
import com.ptithcm.entity.TrangThaiEntity;

@Service
public class TrangThaiService {
	
	@Autowired
	private TrangThaiDao dao;
	
	public TrangThaiEntity getID1() {
		return dao.getID1();
	}
	
	public TrangThaiEntity getID2() {
		return dao.getID2();
	}
	
	public TrangThaiEntity getID3() {
		return dao.getID3();
	}
	
	public TrangThaiEntity getID4() {
		return dao.getID4();
	}
}
