package com.ptithcm.service;

import java.util.List;

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
	
	public boolean checkUsernameExist(String username) {
		return dao.checkUserNameExist(username);
	}
	
	public List<TaiKhoanEntity> getListTK() {
		return dao.getListTaiKhoan();
	}
	
	public TaiKhoanEntity getTKLogin() {
		return dao.getTKLogin();
	}
	
	public void changeStatusAccount(TaiKhoanEntity tk) {
		dao.changeStatusAccount(tk);
	}
	
	public TaiKhoanEntity getTKByUsername(String username) {
		return dao.getTKByUsername(username);
	}
	
	public void ChangePassword(TaiKhoanEntity tk, String rawpassword) {
		dao.ChangePassword(tk, rawpassword);
	}
	
	public void ResetTaiKhoan(TaiKhoanEntity tk) {
		dao.ResetPassword(tk);
	}
}
