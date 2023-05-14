package com.ptithcm.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.TaiKhoanEntity;
import com.ptithcm.entity.TrangThaiEntity;
import com.ptithcm.service.BaiVietService;
import com.ptithcm.service.TaiKhoanService;
import com.ptithcm.service.TrangThaiService;

@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	private BaiVietService bvService;
	
	@Autowired
	private TrangThaiService ttService;
	
	@Autowired
	private TaiKhoanService tkService;
	
	@RequestMapping("")
	public String show() {
		return "admin/main";
	}
	
	@RequestMapping("/list_post_wait")
	public String listwait(Model model) {
		return "admin/list_post_wait";
	}
	
	@RequestMapping("/list_post")
	public String listAllpost() {
		return "admin/list_post";
	}
	
	@RequestMapping("/list_account")
	public String listAccount() {
		return "admin/list_account";
	}
	
	
	@RequestMapping("/list_post_wait/info")
	public String showinfo(@RequestParam("id") String id, Model model) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		model.addAttribute("TenCT", bv.getTenct());
		model.addAttribute("TieuDe", bv.getTieude());
		model.addAttribute("NgayKetThuc", bv.getNgaykt());
		model.addAttribute("LuotXem", bv.getLuotxem());
		model.addAttribute("NgayBatDau", bv.getNgaybd());
		model.addAttribute("NamKNYeuCau", bv.getNamkn());
		model.addAttribute("Luong", bv.getMucluong());
		model.addAttribute("HinhThuc", bv.getLoaicv());
		model.addAttribute("ViTri", bv.getVitri());
		model.addAttribute("SLTuyen", bv.getSoluong());
		model.addAttribute("TrinhDo", bv.getTdEntity().getNoidung());
		model.addAttribute("DiaChi", bv.getDiachi());
		model.addAttribute("Khuvuc", bv.getKhuvuc());
		model.addAttribute("Mota", bv.getNoidung());
		model.addAttribute("id", bv.getId());
		model.addAttribute("btn_block", true);
		return "admin/info_post";
	}
	
	@RequestMapping("/list_post/info")
	public String showlistinfo(@RequestParam("id") String id, Model model) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		model.addAttribute("TenCT", bv.getTenct());
		model.addAttribute("TieuDe", bv.getTieude());
		model.addAttribute("NgayKetThuc", bv.getNgaykt());
		model.addAttribute("LuotXem", bv.getLuotxem());
		model.addAttribute("NgayBatDau", bv.getNgaybd());
		model.addAttribute("NamKNYeuCau", bv.getNamkn());
		model.addAttribute("Luong", bv.getMucluong());
		model.addAttribute("HinhThuc", bv.getLoaicv());
		model.addAttribute("ViTri", bv.getVitri());
		model.addAttribute("SLTuyen", bv.getSoluong());
		model.addAttribute("TrinhDo", bv.getTdEntity().getNoidung());
		model.addAttribute("DiaChi", bv.getDiachi());
		model.addAttribute("Khuvuc", bv.getKhuvuc());
		model.addAttribute("Mota", bv.getNoidung());
		model.addAttribute("id", bv.getId());
		model.addAttribute("btn_block", false);
		return "admin/info_post";
	}
	
	@RequestMapping("/list_post_wait/accept")
	public String acceptbv(@RequestParam("id") String id) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		TrangThaiEntity tt = ttService.getID2();
		bvService.setTrangThai(bv, tt);
		
		return "redirect:/admin/list_post_wait";
	}
	
	@RequestMapping("/list_post_wait/deny")
	public String denybv(@RequestParam("id") String id) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		TrangThaiEntity tt = ttService.getID3();
		bvService.setTrangThai(bv, tt);
		
		return "redirect:/admin/list_post_wait";
	}
	
	@RequestMapping("/change-status")
	public String changeStatusAccount(@RequestParam("username") String username) {
		TaiKhoanEntity tk = tkService.getTKByUsername(username);
		tkService.changeStatusAccount(tk);
		return "redirect:/admin/list_account";
	}
	
	@RequestMapping("/info_user")
	public String showinfo_user(@RequestParam("username") String username, Model model) {
		TaiKhoanEntity tk = tkService.getTKByUsername(username);
		NguoiDungEntity nd = tk.getNdEntity();
		model.addAttribute("ho", nd.getHo());
		model.addAttribute("ten", nd.getTen());
		model.addAttribute("cmnd", nd.getCmnd());
		model.addAttribute("email", nd.getEmail());
		model.addAttribute("sdt", nd.getSdt());
		model.addAttribute("ngaysinh", nd.getNgaysinh());
		model.addAttribute("diachi", nd.getDiachi());
		model.addAttribute("gioitinh", nd.isPhai()?"Nam":"Nữ");
		return "admin/info_user";
	}
	
	@RequestMapping("/changePassword")
	public String ChangePasswordShow() {
		return "admin/changeAdminPW";
	}
	
	@RequestMapping("/changePassword/submit")
	public String ChangePassword(@RequestParam("old-password") String oldPassword, @RequestParam("new-password") String newPassword, @RequestParam("confirm-password") String confirmPassword, Model model) {
		TaiKhoanEntity tk = tkService.getTKLogin();
		BCryptPasswordEncoder bcryt = new BCryptPasswordEncoder();
		
		if (!bcryt.matches(oldPassword, tk.getPassword())) {
			model.addAttribute("message", "Mật khẩu cũ chính xác");
			return "redirect:/admin/changePassword";
		}
		
		if (!newPassword.equals(confirmPassword)) {
			model.addAttribute("message", "Mật khẩu xác nhận không chính xác");
			return "redirect:/admin/changePassword";
		}
		
		tkService.ChangePassword(tk, newPassword);
		
		return "redirect:/admin";
	}
	
	
	@ModelAttribute("lbv")
	private List<BaiVietEntity> listbv() {
		return bvService.lisBaiVietCD();
	}
	
	@ModelAttribute("lallbv")
	private List<BaiVietEntity> listallbv() {
		return bvService.getListBV();
	}
	
	@ModelAttribute("ltk")
	private List<TaiKhoanEntity> listtk() {
		return tkService.getListTK();
	}
}
