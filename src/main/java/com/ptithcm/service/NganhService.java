package com.ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.NganhDao;
import com.ptithcm.entity.NganhEntity;

@Service
public class NganhService {
	
	@Autowired
	private NganhDao dao;
	
	public List<NganhEntity> getlist() {
		return dao.getlist();
	}
	
	public NganhEntity getNganhbyNoidung(String noidung) {
		return dao.getNganhByNoiDung(noidung);
	}
	
	public NganhEntity getNganhByID(int id) {
		return dao.getNganhByID(id);
	}
}
