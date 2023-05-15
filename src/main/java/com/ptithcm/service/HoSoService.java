package com.ptithcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.HoSoDao;
import com.ptithcm.entity.HoSoEntity;

@Service
public class HoSoService {
	
	@Autowired
	private HoSoDao dao;
	
	public void addHoso(HoSoEntity hoso) {
		 dao.addHoSo(hoso);
	}
	
	public void changeHoso(HoSoEntity hoso) {
		dao.changeHoSo(hoso);
	}
}
