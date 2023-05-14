package com.ptithcm.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.QuyenEntity;
import com.ptithcm.entity.TaiKhoanEntity;
import com.ptithcm.service.NguoiDungService;
import com.ptithcm.service.QuyenService;
import com.ptithcm.service.TaiKhoanService;

@Controller
public class LoginAndRegister {
	
	@Autowired
	private QuyenService quService;
	
	@Autowired
	private NguoiDungService ndService;
	
	@Autowired
	private TaiKhoanService tkService;
	
	public static String username_reg;
	public static String password_reg;
	public static int error_code = 100;
	
	
	@RequestMapping("register")
	public String redirectRegister() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String addInformation(@RequestParam("username") String username, @RequestParam("password-reg") String password, Model model) {
		username_reg = username;
		password_reg = password;
		if (tkService.checkUsernameExist(username)) {
			error_code = 101;
			return "redirect:/login";
		}
		return "register";
	}
	
	@RequestMapping(value = "NewAccount", method = RequestMethod.POST)
	public String registerNewAccount(@RequestParam("ho") String ho, @RequestParam("ten") String ten, @RequestParam("gioitinh") String gioitinh, @RequestParam("ngaysinh") String ngaysinh,
			@RequestParam("sdt") String sdt, @RequestParam("cmnd") String cmnd, @RequestParam("diachi") String diachi, @RequestParam("email") String email, @RequestParam("role") String role) {
		System.out.println(ho+" "+ten+" "+gioitinh+" "+ ngaysinh+" "+sdt+" "+cmnd+" "+diachi+" "+email+" "+role);
		
		TaiKhoanEntity tk  = new TaiKhoanEntity();
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String passencode = bcrypt.encode(password_reg);
		tk.setPassword(passencode);
		tk.setUsername(username_reg);
		
		if (role.compareTo("0") == 0) {
			tk.setQuEntity(quService.getRoleB());
		}
		else {
			tk.setQuEntity(quService.getRoleC());
		}
		
		NguoiDungEntity nd = new NguoiDungEntity();
		nd.setHo(ho);
		nd.setTen(ten);
		nd.setPhai(gioitinh.compareTo("nam") == 0?true:false);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(ngaysinh);
			nd.setNgaysinh(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		nd.setCmnd(cmnd);
		nd.setDiachi(diachi);
		nd.setEmail(email);
		nd.setSdt(sdt);
		ndService.addNguoiDung(nd);
		tk.setNdEntity(nd);
		tk.setTrangthai(true);
		tkService.Dangky(tk);
		
		
		return "redirect:/login";
		
	}
	
	@RequestMapping(value = "login")
	public String keepLogin(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error!= null) {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
		}
		if (error_code == 101) {
			model.addAttribute("error_username", "Tên tài khoản đã tồn tại vui lòng nhập tên khác");
			error_code = 100;
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String Logout() {
		return "redirect:/login";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null)
		{
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_A")))
				return "redirect:/admin";	
			else
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_B")))
				return "redirect:/recruiter";
			else
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_B")))
				return "redirect:/job_seeker";
			else
				return "redirect:/404";
		}
		return "redirect:/404";
	}
	
	
}
