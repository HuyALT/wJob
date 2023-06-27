package com.ptithcm.controller;

import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.entity.HoSoEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.QuyenEntity;
import com.ptithcm.entity.TaiKhoanEntity;
import com.ptithcm.service.HoSoService;
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
	
	@Autowired
	private HoSoService hosoService;
	
	@Autowired
	private MailSender mailer;
	
	public static String username_reg;
	public static String password_reg;
	public static String email_reg;
	public static int error_code = 100;
	public static boolean keeplogin = false;
	public static String confirm_code;
	
	private String email_host = "huytn102030z@gmail.com";
	
	@RequestMapping("register")
	public String redirectRegister() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "mailconfirm", method = RequestMethod.POST)
	public String addInformation(@RequestParam("username") String username, @RequestParam("password-reg")
	String password, Model model, @RequestParam("email") String email) {
		username_reg = username;
		password_reg = password;
		email_reg = email;
		if (tkService.checkUsernameExist(username)) {
			error_code = 101;
			return "redirect:/login";
		}
		if (ndService.getNguoiDungByEmail(email)!=null) {
			error_code = 102;
			return "redirect:/login";
		}
		if (error_code ==100) {
			try {
				sendMail();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "mailconfirm";
	}
	
	private void sendMail() throws UnsupportedEncodingException, MessagingException {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String ranStr = buffer.toString();
		confirm_code = ranStr;
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(email_host);
		message.setTo(email_reg);
		message.setSubject("WJOB TEAM");
		message.setText("Mã xác nhận của bạn là: "+confirm_code);
		mailer.send(message);
		
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String mailConfirm(@RequestParam("code") String code) {
		if (code.equals(confirm_code)) {
			return "register";
		}
		return "redirect:/login";
	}
	
	
	
	@RequestMapping(value = "NewAccount", method = RequestMethod.POST)
	public String registerNewAccount(@RequestParam("ho") String ho, @RequestParam("ten") String ten, 
			@RequestParam("gioitinh") String gioitinh, @RequestParam("ngaysinh") String ngaysinh,
			@RequestParam("sdt") String sdt, @RequestParam("cmnd") String cmnd,
			@RequestParam("diachi") String diachi, @RequestParam("role") String role) {
		
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
		nd.setEmail(email_reg);
		nd.setSdt(sdt);
		ndService.addNguoiDung(nd);
		tk.setNdEntity(nd);
		tk.setTrangthai(true);
		tkService.Dangky(tk);
		
		HoSoEntity hoso = new HoSoEntity();
		hoso.setNdEntity(nd);
		
		if (tk.getQuEntity().getTenQuyen().equals("C")) {
			hosoService.addHoso(hoso);
		}
		
		return "redirect:/login";
		
	}
	
	@RequestMapping("forget_password")
	public String showForgetPass(Model model) {
		if (error_code == 111) {
			error_code = 100;
			model.addAttribute("message", "Email không tồn tại");
		}
		return "forget_pass_email";
	}
	
	@RequestMapping("forget_pass_email")
	public String confirm_email(@RequestParam("email") String email) {
		NguoiDungEntity nd = ndService.getNguoiDungByEmail(email.trim());
		email_reg = email;
		if (nd == null) {
			error_code = 111;
			return "redirect:/forget_password";
		}
		try {
			sendMail();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "confirm_resetpass";
	}
	
	@RequestMapping(value = "resetpass", method = RequestMethod.POST)
	public String resetPassword(@RequestParam("code") String code) throws Exception {
		NguoiDungEntity nd = ndService.getNguoiDungByEmail(email_reg);
		if (!code.equals(confirm_code)) {
			return "redirect:/login";
		}
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String ranStr = buffer.toString();
	    
	    tkService.ChangePassword(nd.getTknd(), ranStr);
	    
	    SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(email_host);
		message.setTo(email_reg);
		message.setSubject("WJOB TEAM");
		message.setText("User name là: "+nd.getTknd().getUsername()+"\n"+"Mật khẩu là: "+ranStr);
		mailer.send(message);
	    return "Success";
	}
	
	@RequestMapping(value = "login")
	public String keepLogin(@RequestParam(value = "error", required = false) String error, Model model) {
		username_reg = "";
		email_reg = "";
		password_reg = "";
		confirm_code = "";
		if (error!= null) {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
		}
		if (error_code == 101) {
			model.addAttribute("error_username", "Tên tài khoản đã tồn tại vui lòng nhập tên khác");
			error_code = 100;
		}
		if (error_code == 102) {
			model.addAttribute("error_username", "Email đã được đăng kí");
			error_code =100;
		}
		if (keeplogin) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth!=null)
			{
				if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_A")))
					return "redirect:/admin";	
				else
				if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_B")))
					return "redirect:/recruiter";
				else
				if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_C")))
					return "redirect:/job_seeker";
				else
					return "redirect:/404";
			}
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String Logout() {
		keeplogin = false;
		return "redirect:/login";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null)
		{
			keeplogin = true;
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_A")))
				return "redirect:/admin";	
			else
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_B")))
				return "redirect:/recruiter";
			else
			if (auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_C")))
				return "redirect:/job_seeker";
			else
				return "redirect:/404";
		}
		return "redirect:/404";
	}
	
	
}
