package com.ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "BAIVIET")
public class BaiVietEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TIEUDE")
	private String tieude;

	@Column(name = "NOIDUNG")
	private String noidung;

	@Column(name = "NGAYBATDAU")
	private Date ngaybd;

	@Column(name = "NGAYKETTHUC")
	private Date ngaykt;

	@Column(name = "DIACHI")
	private String diachi;

	@Column(name = "EMAILLH")
	private String emaillh;

	@Column(name = "SDTLH")
	private String sdtlh;

	@Column(name = "LUOTXEM")
	private int luotxem;

	@Column(name = "LOAICV")
	private String loaicv;

	@Column(name = "MUCLUONG")
	private int mucluong;

	@Column(name = "VITRI")
	private String vitri;
	
	@Column(name = "SOLUONGTUYEN")
	private int soluong;
	
	@Column(name = "NAMKINHNGHIEM")
	private int namkn;
	
	@Column(name = "KHUVUC")
	private String khuvuc;
	
	@Column(name = "TENCT")
	private String tenct;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDNGANH")
	private NganhEntity nganhEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTRINHDO")
	private TrinhDoEntity tdEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTT")
	private TrangThaiEntity ttEntity;

	public BaiVietEntity() {
		super();
	}

	

	public BaiVietEntity(int id, String tieude, String noidung, Date ngaybd, Date ngaykt, String diachi, String emaillh,
			String sdtlh, int luotxem, String loaicv, int mucluong, String vitri, int soluong, int namkn, String khuvuc,
			String tenct, NguoiDungEntity ndEntity, NganhEntity nganhEntity, TrinhDoEntity tdEntity, TrangThaiEntity ttEntity) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.noidung = noidung;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.diachi = diachi;
		this.emaillh = emaillh;
		this.sdtlh = sdtlh;
		this.luotxem = luotxem;
		this.loaicv = loaicv;
		this.mucluong = mucluong;
		this.vitri = vitri;
		this.soluong = soluong;
		this.namkn = namkn;
		this.khuvuc = khuvuc;
		this.tenct = tenct;
		this.ndEntity = ndEntity;
		this.nganhEntity = nganhEntity;
		this.tdEntity = tdEntity;
		this.ttEntity = ttEntity;
	}

	public int getSoluong() {
		return soluong;
	}

	public String getTenct() {
		return tenct;
	}
	public void setTenct(String tenct) {
		this.tenct = tenct;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getNamkn() {
		return namkn;
	}

	public void setNamkn(int namkn) {
		this.namkn = namkn;
	}

	public String getKhuvuc() {
		return khuvuc;
	}

	public void setKhuvuc(String khuvuc) {
		this.khuvuc = khuvuc;
	}



	public int getMucluong() {
		return mucluong;
	}

	public void setMucluong(int mucluong) {
		this.mucluong = mucluong;
	}

	public String getVitri() {
		return vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmaillh() {
		return emaillh;
	}

	public void setEmaillh(String emaillh) {
		this.emaillh = emaillh;
	}

	public String getSdtlh() {
		return sdtlh;
	}

	public void setSdtlh(String sdtlh) {
		this.sdtlh = sdtlh;
	}

	public int getLuotxem() {
		return luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	public NguoiDungEntity getNdEntity() {
		return ndEntity;
	}

	public void setNdEntity(NguoiDungEntity ndEntity) {
		this.ndEntity = ndEntity;
	}

	public TrangThaiEntity getTtEntity() {
		return ttEntity;
	}

	public void setTtEntity(TrangThaiEntity ttEntity) {
		this.ttEntity = ttEntity;
	}

	public String getLoaicv() {
		return loaicv;
	}

	public void setLoaicv(String loaicv) {
		this.loaicv = loaicv;
	}

	public NganhEntity getNganhEntity() {
		return nganhEntity;
	}

	public void setNganhEntity(NganhEntity nganhEntity) {
		this.nganhEntity = nganhEntity;
	}

	public TrinhDoEntity getTdEntity() {
		return tdEntity;
	}

	public void setTdEntity(TrinhDoEntity tdEntity) {
		this.tdEntity = tdEntity;
	}

}
