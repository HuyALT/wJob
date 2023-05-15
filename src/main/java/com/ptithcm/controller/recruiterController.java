package com.ptithcm.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.entity.BaiVietEntity;
import com.ptithcm.entity.NganhEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.TaiKhoanEntity;
import com.ptithcm.entity.TrangThaiEntity;
import com.ptithcm.entity.TrinhDoEntity;
import com.ptithcm.service.BaiVietService;
import com.ptithcm.service.NganhService;
import com.ptithcm.service.NguoiDungService;
import com.ptithcm.service.TaiKhoanService;
import com.ptithcm.service.TrangThaiService;
import com.ptithcm.service.TrinhDoService;

@Controller
@RequestMapping("/recruiter")
public class recruiterController {
	
	@Autowired
	private TaiKhoanService tkService;
	
	@Autowired
	private BaiVietService bvService;
	
	@Autowired
	private NganhService nganhService;
	
	@Autowired
	private TrangThaiService ttService;
	
	@Autowired
	private TrinhDoService tdService;
	
	@Autowired
	private NguoiDungService ndService;
	
	public static int errorcode = 100;
	
	@RequestMapping("")
	public String recruiterLoad(Model model) {
		
		model.addAttribute("lbv", bvService.getBVDaDuyet());
		
		return "recruiter/main";
	}
	
	@RequestMapping("/search")
	public String searchResult(Model model ,@RequestParam("job") String job, @RequestParam("position") String position, @RequestParam("formality") String formality) {
		model.addAttribute("lbv", bvService.searchWithCon(job, formality, position));
		return "recruiter/main";
	}
	
	@RequestMapping("/new-post")
	public String showNewPost(Model model) {
		model.addAttribute("emaillh", tkService.getNDlogin().getEmail());
		model.addAttribute("sdtlh", tkService.getNDlogin().getSdt());
		return "recruiter/newpost";
	}
	
	@RequestMapping("/post")
	public String Addpost(@RequestParam("tieude") String tieude, @RequestParam("tenct") String tenct, @RequestParam("date") String date, @RequestParam("namkn") String namkn,
			@RequestParam("luong") String luong, @RequestParam("hinhthuc") String hinhthuc, @RequestParam("vitri") String vitri, @RequestParam("soluong") String soluong,
			@RequestParam("trinhdo") String trinhdo, @RequestParam("khuvuc") String khuvuc, @RequestParam("mota") String mota, @RequestParam("diachi") String diachi, @RequestParam("nganh") String nganh,
			@RequestParam("email") String email, @RequestParam("sdt") String sdt) {
		TrangThaiEntity tt = ttService.getID1();
		NguoiDungEntity nd = tkService.getNDlogin();
		NganhEntity ng = nganhService.getNganhByID(Integer.parseInt(nganh));
		TrinhDoEntity td = tdService.getTrinhDoByID(Integer.parseInt(trinhdo));
		BaiVietEntity bv = new BaiVietEntity();
		
		bv.setEmaillh(email);
		
		bv.setSdtlh(sdt);
		
		bv.setTieude(tieude);
		
		bv.setTenct(tenct);
		
		long milis = System.currentTimeMillis();
		Date ngaybd = new Date(milis);
		bv.setNgaybd(ngaybd);
		LocalDate localdate = LocalDate.parse(date);
		Date ngaykt = Date.valueOf(localdate);
		bv.setNgaykt(ngaykt);
		bv.setDiachi(diachi);
		bv.setKhuvuc(diachi);
		bv.setNdEntity(nd);
		bv.setTtEntity(tt);
		bv.setNganhEntity(ng);
		bv.setSoluong(Integer.parseInt(soluong));
		bv.setNamkn(Integer.parseInt(namkn));
		bv.setLuotxem(0);
		bv.setMucluong(Integer.parseInt(luong));
		bv.setLoaicv(hinhthuc);
		bv.setTdEntity(td);
		bv.setNoidung(mota);
		bv.setVitri(vitri);
		
		bvService.addBaiViet(bv);
		
		return "redirect:/recruiter";
		
	}
	
	@RequestMapping("user-info")
	public String userInfo(Model model) {
		model.addAttribute("ho", tkService.getNDlogin().getHo());
		model.addAttribute("ten", tkService.getNDlogin().getTen());
		model.addAttribute("cmnd", tkService.getNDlogin().getCmnd());
		model.addAttribute("email", tkService.getNDlogin().getEmail());
		model.addAttribute("sdt", tkService.getNDlogin().getSdt());
		model.addAttribute("ngaysinh", tkService.getNDlogin().getNgaysinh());
		model.addAttribute("diachi", tkService.getNDlogin().getDiachi());
		model.addAttribute("gioitinh", tkService.getNDlogin().isPhai());
		
		if (errorcode == 101) {
			errorcode =100;
			model.addAttribute("message", "Mật khẩu không chính xác");
			model.addAttribute("success", false);
		}
		if (errorcode == 102) {
			errorcode =100;
			model.addAttribute("message", "Đổi mật khẩu thành công");
			model.addAttribute("success", true);
		}
		
		if (errorcode == 103) {
			errorcode =100;
			model.addAttribute("smessage", "Thay đổi đã được ghi nhận");
		}
		
		return "recruiter/info_user";
	}
	
	@RequestMapping(value = "changepassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("old-pass") String old_pass, @RequestParam("new-pass") String new_pass, @RequestParam("confirm-pass") String confirm_pass, Model model) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		TaiKhoanEntity tk = tkService.getTKLogin();
		
		
		if (!bCrypt.matches(old_pass, tk.getPassword())) {
			
			errorcode = 101;
			return "redirect:/recruiter/user-info";
		}
		
		tkService.ChangePassword(tk, new_pass);
		
		errorcode = 102;
		
		return "redirect:/recruiter/user-info";
	}
	
	@RequestMapping(value = "changeinfo", method = RequestMethod.POST)
	public String changeinfo(@RequestParam("ho") String ho, @RequestParam("ten") String ten, @RequestParam("cmnd") String cmnd,
			@RequestParam("sdt") String sdt, @RequestParam("ngaysinh") String ngaysinh, @RequestParam("diachi") String diachi, @RequestParam("phai") String phai) {
		NguoiDungEntity nd = tkService.getNDlogin();
		nd.setHo(ho);
		nd.setTen(ten);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		try {
			date = format.parse(ngaysinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nd.setNgaysinh(date);
		nd.setCmnd(cmnd);
		nd.setSdt(sdt);
		nd.setDiachi(diachi);
		
		ndService.changeInfomation(nd);
		
		errorcode = 103;
		
		return "redirect:/recruiter/user-info";
	}
	
	@RequestMapping("job_info")
	public String postinfo(Model model, @RequestParam("id") String id) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		model.addAttribute("TenCT", bv.getTenct());
		model.addAttribute("TieuDe", bv.getTieude());
		model.addAttribute("NgayKetThuc",bv.getNgaykt());
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
		model.addAttribute("email", bv.getEmaillh());
		model.addAttribute("sdt", bv.getSdtlh());
		model.addAttribute("Mota", bv.getNoidung());
		
		
		return "recruiter/post_info";
	}
	
	@RequestMapping("like-list")
	public String showlikeList(Model model, String id) {
		
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		model.addAttribute("lqt", bv.getLqt());
		return "recruiter/like_list";
		
	}
	
	@RequestMapping("user_liked_info")
	public String showuserlikeInfo(@RequestParam("id") String id, Model model) {
		NguoiDungEntity nd = ndService.getNguoiDungByID(Integer.parseInt(id));
		model.addAttribute("ho", nd.getHo());
		model.addAttribute("ten", nd.getTen());
		model.addAttribute("phai", nd.isPhai()?"Nam":"Nữ");
		model.addAttribute("trinhdo", nd.getHsnd().getTdEntity()==null?"Trống":nd.getHsnd().getTdEntity().getNoidung());
		model.addAttribute("chuyennganh", nd.getHsnd().getNganhEntity()==null?"Trống":nd.getHsnd().getNganhEntity().getNoidung());
		model.addAttribute("email", nd.getEmail());
		model.addAttribute("sdt", nd.getSdt());
		model.addAttribute("mota", nd.getHsnd().getNoidung()==null?"":nd.getHsnd().getNoidung());
		return "recruiter/user_liked_info";
		
	}
	
	@RequestMapping("my-post")
	public String showMyPost() {
		return "recruiter/my_post";
	}
	
	@ModelAttribute("lmybv")
	public List<BaiVietEntity> listMyPost() {
		return bvService.getlistMyBV();
	}
	
	
	@ModelAttribute("lbv")
	public List<BaiVietEntity> listBV() {
		return bvService.getBVDaDuyet();
	}
	
	@ModelAttribute("lng")
	public List<NganhEntity> listNganh() {
		return nganhService.getlist();
	}
	
	@ModelAttribute("username")
	public String showUsername() {
		return tkService.getTKLogin().getUsername();
	}
	
}
