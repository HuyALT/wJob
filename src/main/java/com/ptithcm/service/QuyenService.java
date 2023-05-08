package com.ptithcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.QuyenDao;
import com.ptithcm.entity.QuyenEntity;

@Service
public class QuyenService {
	
	@Autowired
	private QuyenDao dao;
	
	public QuyenEntity getRoleB() {
		return dao.getRoleB();
	}
	
	public QuyenEntity getRoleC() {
		return dao.getRoleC();
	}
}
