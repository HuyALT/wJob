package com.ptithcm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.ptithcm.entity.HoSoEntity;
import com.ptithcm.entity.NganhEntity;
import com.ptithcm.entity.NguoiDungEntity;
import com.ptithcm.entity.UngTuyenEntity;
import com.ptithcm.entity.TaiKhoanEntity;
import com.ptithcm.entity.TrinhDoEntity;
import com.ptithcm.service.BaiVietService;
import com.ptithcm.service.HoSoService;
import com.ptithcm.service.NganhService;
import com.ptithcm.service.NguoiDungService;
import com.ptithcm.service.UngTuyenService;
import com.ptithcm.service.TaiKhoanService;
import com.ptithcm.service.TrinhDoService;

@Controller
@RequestMapping("/job_seeker")
public class job_seekerController {

	@Autowired
	private TaiKhoanService tkService;
	
	@Autowired
	private BaiVietService bvService;
	
	@Autowired
	private TrinhDoService tdService;
	
	@Autowired
	private NganhService nganhService;
	
	@Autowired
	private HoSoService hsService;
	
	@Autowired
	private NguoiDungService ndService;
	
	@Autowired
	private UngTuyenService qtService;
	
	public static int errorcode = 100;
	
	@RequestMapping("")
	String showmain(Model model) {
		model.addAttribute("lbv", bvService.getBVDaDuyet());
		return "job_seeker/main";
	}
	
	@RequestMapping("/search")
	public String searchResult(Model model ,@RequestParam("job") String job, @RequestParam("position") String position, @RequestParam("formality") String formality) {
		model.addAttribute("lbv", bvService.searchWithCon(job, formality, position));
		return "job_seeker/main";
	}
	
	@RequestMapping("job_info")
	public String postinfo(Model model, @RequestParam("id") String id) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		bvService.add1View(bv);
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
		model.addAttribute("idbv", bv.getId());
		
		List<UngTuyenEntity> dsqtbv = qtService.getlistByIDBV(bv.getId());
		
		UngTuyenEntity ndqt = dsqtbv.stream().filter(o->o.getNdEntity().getId()==tkService.getNDlogin().getId()).findFirst().orElse(null);
		Date now = new Date();
	
		if (ndqt!=null) {
			model.addAttribute("islike", false);
			model.addAttribute("text","Đã ứng tuyển");
		}else
		if (bv.getNgaykt().compareTo(now)<0) {
				model.addAttribute("text","Đã hết hạn");
				model.addAttribute("islike", false);
		}
		else
		{
			model.addAttribute("islike", true);
			model.addAttribute("text","Ứng tuyển");
		}
		
		model.addAttribute("lbvt3", bvService.selectTop3(bv.getNganhEntity().getNoidung(), bv.getId()));
		
		return "job_seeker/post_info";
	}
	
	@RequestMapping("like")
	public String likepost(@RequestParam("id") String id) {
		BaiVietEntity bv = bvService.getbvByID(Integer.parseInt(id));
		NguoiDungEntity nd = tkService.getNDlogin();
		
		qtService.addLike(bv, nd);
		return "redirect:/job_seeker/job_info?id="+id;
	}
	
	@RequestMapping("account-center")
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
		
		
		
		return "job_seeker/account_info";
	}
	
	@RequestMapping("my-info")
	public String showMyInfo(Model model) {
		NguoiDungEntity ndDungEntity = tkService.getNDlogin();
		model.addAttribute("ho", ndDungEntity.getHo());
		model.addAttribute("ten", ndDungEntity.getTen());
		model.addAttribute("tdnd", ndDungEntity.getHsnd().getTdEntity()==null?0:ndDungEntity.getHsnd().getTdEntity().getId());
		model.addAttribute("cnnd", ndDungEntity.getHsnd().getNganhEntity()==null?0:ndDungEntity.getHsnd().getNganhEntity().getId());
		model.addAttribute("mota", ndDungEntity.getHsnd().getNoidung()==null?"":ndDungEntity.getHsnd().getNoidung());
		if (errorcode==111) {
			errorcode=100;
			model.addAttribute("message", "Thay đổi thành công");
		}
		return "job_seeker/my_info";
	}
	
	@RequestMapping("changeportfolio")
	public String changePortfolio(@RequestParam("trinhdo") String td,
			@RequestParam("chuyennganh") String cn, @RequestParam("mota") String mota) {
		HoSoEntity hs = tkService.getNDlogin().getHsnd();
		if (td.equals("0")) {
			hs.setTdEntity(null);
		}
		else {
			hs.setTdEntity(tdService.getTrinhDoByID(Integer.parseInt(td)));
		}
		
		if (cn.equals("0")) {
			hs.setNganhEntity(null);
		}
		else {
			hs.setNganhEntity(nganhService.getNganhByID(Integer.parseInt(cn)));
		}
		
		hs.setNoidung(mota);
		
		
		hsService.changeHoso(hs);
		errorcode = 111;
		
		return "redirect:/job_seeker/my-info";
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
		
		return "redirect:/job_seeker/account-center";
	}
	
	@RequestMapping(value = "changepassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("old-pass") String old_pass, @RequestParam("new-pass") String new_pass, @RequestParam("confirm-pass") String confirm_pass, Model model) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		TaiKhoanEntity tk = tkService.getTKLogin();
		
		
		if (!bCrypt.matches(old_pass, tk.getPassword())) {
			
			errorcode = 101;
			return "redirect:/job_seeker/account-center";
		}
		
		tkService.ChangePassword(tk, new_pass);
		
		errorcode = 102;
		
		return "redirect:/job_seeker/account-center";
	}
	
	@RequestMapping("suggest_for_you")
	public String suggest(Model model) {
		NguoiDungEntity nd = tkService.getNDlogin();
		
		HoSoEntity hs = nd.getHsnd();
		if (hs.getNganhEntity() == null || hs.getTdEntity() == null) {
			return "job_seeker/Nosuggest";
		}
		model.addAttribute("lbvsuggest", bvService.searchWithCon(hs.getNganhEntity().getNoidung(), "", ""));
		return "job_seeker/suggest";
		
	}
	
	@RequestMapping("liked_post")
	public String likedpost(Model model) {
		NguoiDungEntity nd = tkService.getNDlogin();
		List<BaiVietEntity> lbv = new ArrayList<>();
		nd.getQtbv().stream().forEach(o->lbv.add(o.getBvEntity()));
		
		model.addAttribute("lbvliked", lbv);
		return "job_seeker/liked_post";
	}
	
	@ModelAttribute("ltd")
	public List<TrinhDoEntity> getlistTD() {
		return tdService.getlist();
	}
	
	@ModelAttribute("lng")
	public List<NganhEntity> getlistNganh() {
		return nganhService.getlist();
	}
	
	@ModelAttribute("username")
	public String showUsername() {
		return tkService.getTKLogin().getUsername();
	}
}
