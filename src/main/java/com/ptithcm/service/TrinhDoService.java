package com.ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptithcm.dao.TrinhDoDao;
import com.ptithcm.entity.TrinhDoEntity;

@Service
public class TrinhDoService {
	
	@Autowired
	private TrinhDoDao dao;
	
	public List<TrinhDoEntity> getlist() {
		return dao.getlist();
	}
	
	public TrinhDoEntity getTrinhDoByID(int id) {
		return dao.getTrinhdoByID(id);
	}
}
